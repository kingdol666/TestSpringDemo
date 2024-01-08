package com.kingdol.testspringdemo1.controller;
import com.kingdol.testspringdemo1.Interface.MyInterface;
import com.kingdol.testspringdemo1.Interface.isNumber;
import com.kingdol.testspringdemo1.api.Response;
import com.kingdol.testspringdemo1.entity.UserEntity;
import com.kingdol.testspringdemo1.repository.MyRepository;
import com.kingdol.testspringdemo1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Function;

@RestController
@Tag(name = "测试Controller", description = "这是描述")
public class TestController {
    private final UserService userService;

    @Autowired
    private MyRepository myRepository;

    @Autowired
    public TestController(UserService userService) {
        Assert.notNull(userService, "MyCollaborator must not be null!");
        this.userService = userService;
    }


    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        return "hello world";
    }

    @GetMapping("/")
    public Response<?> test2() {
        Response<String> response = new Response<>();
        Map<String, Object> test = new HashMap<>();
        test.put("name", "张三");
        test.put("age", 20);
        test.put("sex", "男");
        test.put("hobby", "打篮球");
        test.put("address", "北京");
        JSONObject jsonObject = new JSONObject(test);
        response.success(jsonObject.toString());
        return response;
    }

    @GetMapping("/test1")
    public Response<?> test1() {
        Response<UserEntity> response = new Response<>();
        response.setCode(200);
        response.setMessage("success");
        UserEntity userEntity = userService.getUserByName("张三");
        response.setData(userEntity);
        System.out.println(userEntity);
        return response;
    }

    @GetMapping("/test3")
    public Response<List<UserEntity>> test3() {
        List<UserEntity> userEntity = userService.getAllUsers();
        Response<List<UserEntity>> response = Response.ok(userEntity);
        System.out.println(response);
        return response;
    }

    @GetMapping("/error")
    public Response<?> error() {
        Response<?> response = Response.error("error", 500);
        System.out.println(response);
        return response;
    }

    @GetMapping("/hello")
    @Operation(summary = "测试接口")
    public String index(@Parameter(name = "name", description = "名称") String name) {
        return "hello " + name;
    }

    @PostMapping("/saveUser")
    @Operation(summary = "测试创建")
    public String saveUser(@RequestParam @Parameter(name = "name", description = "名称") String name, @RequestParam @Parameter(name = "password", description = "密码") String password){
        UserEntity user = new UserEntity();
        user.setUsername(name);
        user.setPassword(password);
        return userService.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    //http://localhost:8081/interface
    @GetMapping("interface")
    public String interfaceTest(){
        MyInterface<String, String> myInterface = (a) -> {
            return a;
        };
        Function<String, String> function = myInterface::hello;
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println(a + b);
        };
        biConsumer.accept("张三", "李四");
        return function.apply("张三");
    }
    //http://localhost:8081/testnumber?a=123
    @GetMapping("/testnumber")
    public String testNumber(@RequestParam String a){
        isNumber isNumber = (str)-> str.matches("-?\\d+(\\.\\d+)?");
        String result;
        if(isNumber.start(a)){
            result = "Yes";
        } else {
            result = "No";
        }
        return result;
    }
    //http://localhost:8081/testreactor?a=1&a=2
    @GetMapping("/testreactor")
    public Response<?> testReacor(@RequestParam("a") Integer[] a) throws InterruptedException {
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());
        Function<Integer, Integer> function = integer -> integer * 2;
        Flux<Integer> flux = Flux.just(a).filter((integer)->integer>0).map(function);
        System.out.println(function.apply(1));
//        Mono<List<Integer>> listMono = flux.collectList();
//        List<Integer> result = Collections.synchronizedList(new ArrayList<>());
//        listMono.subscribe(result::addAll);
//        System.out.println(result);
        List<Integer> listFlux = flux.collectList().block();
        System.out.println(listFlux);
        Flux<Integer> integerFlux = flux.concatWith(Flux.just(1, 2, 3))
                .doOnSubscribe(s -> System.out.println("开始订阅"+s));
        integerFlux.subscribe(System.out::println);
        integerFlux.subscribe(integers::add);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Flux<Integer> flux1 = Flux.just(1, 2, 3, 4, 5)
                .delayElements(Duration.ofMillis(10));
        // 创建一个带有参数的内部类Task，并传入参数n
        flux1.subscribe(integer -> executor.submit(new Task(integer, integers)));

        Thread.sleep(1000);
        return Response.ok(integers);
    }

    private record Task(int n, List<Integer> integers) implements Callable<Integer> {

            @Override
            public Integer call() {
                int num = n * n;
                // 在线程中使用参数n进行计算
                integers.add(num);
                System.out.println("计算结果：" + num);
                return num;
            }
    }

    @GetMapping("TestSQL")
    public ResponseEntity<List<Object[]>> TestSQL(){
        String sql = "select * from users";
        List<Object[]> resultList = myRepository.executeNativeQuery(sql);
        System.out.println("sql = " + resultList);
        return ResponseEntity.ok(resultList);
    }

}
