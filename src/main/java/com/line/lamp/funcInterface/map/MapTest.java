package com.line.lamp.funcInterface.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author zsw
 * @date 2021/8/10 11:42
 * java8 的 map
 */
public class MapTest {
    public static void main(String[] args) {

        //map 新特性
        Map<Integer,String> map = new HashMap<Integer,String>();
        for(int i=0; i<6; i++){
            map.put(i,"val_"+i);
        }
        map.put(10,null);

        //1:遍历
        map.forEach((key,value) -> System.out.println(key+":"+value));

        //2:V getOrDefault(key,defaultValue):获取key值,如果key不存在则用defaultValue
        System.out.println("3-->"+map.getOrDefault(3,"val_66"));//3-->val_3
        System.out.println("10-->"+map.getOrDefault(10,"val_66"));//10-->null
        System.out.println("11-->"+map.getOrDefault(11,"val_66"));//11-->val_66

        //3:V putIfAbsent(K key, V value):根据key匹配Node,如果匹配不到则增加key-value,返回null,如果匹配到Node,如果oldValue不等于null则不进行value覆盖，返回oldValue
        System.out.println(map.putIfAbsent(3,"val_66"));//val_3
        System.out.println(map.putIfAbsent(10,"val_66"));//null
        System.out.println(map.putIfAbsent(11,"val_66"));//null
        System.out.println(map.get(3)+"--"+map.get(10)+"--"+map.get(11));//val_3--val_66--val_66

        //4:boolean remove(Object key, Object value):根据key匹配node，如果value也相同则删除
        System.out.println(map.size());//8
        map.remove(10,"66");
        map.remove(11,"val_66");
        System.out.println(map.size());//7
        System.out.println(map.toString());//{0=val_0, 1=val_1, 2=val_2, 3=val_3, 4=val_4, 5=val_5, 10=val_66}

        //5:boolean replace(K key, V oldValue, V newValue):根据key匹配node,如果value也相同则使用newValue覆盖返回true，否则返回false
        map.put(11,null);
        map.replace(3,"3","33");
        map.replace(10,"val_66","val_666666");
        map.replace(11,null,"val_11");
        map.replace(11,null,"val_11");
        System.out.println(map.toString());//{0=val_0, 1=val_1, 2=val_2, 3=val_3, 4=val_4, 5=val_5, 10=val_666666, 11=val_11}
        /** 6:
         * void replaceAll(BiFunction function)：调用此方法时重写BiFunction的Object apply(Object o, Object o2)方法，
         * 其中o为key，o2为value，根据重写方法逻辑进行重新赋值。
         */
        map.replaceAll((key,value) -> {
            if(key == 2){
                return value+"222";
            }
            return value;
        });
        System.out.println(map.toString());//{0=val_0, 1=val_1, 2=val_2222, 3=val_3, 4=val_4, 5=val_5, 10=val_666666, 11=val_11}
        /** 7:
         * V compute(K key,BiFunction remappingFunction)：根据key做匹配，根据BiFunction的apply返回做存储的value。
         * 匹配到Node做value替换，匹配不到新增node。apply的返回值如果为null则删除该节点，否则即为要存储的value。
         */
        System.out.println("---------------------- compute -----------------------");
        System.out.println(map.compute(3,new BiFunction() {
            @Override
            public Object apply(Object key, Object value) {
                return key+":"+value;
            }
        }));//3:val_3 -》用返回值覆盖原来的值，这里用了java7的编码方式，以下均采用java8的lanbda表达式
        System.out.println(map.compute(10,(key,value) -> {return value.split("_")[1];}));//666666 -》用返回值覆盖原来的值
        System.out.println(map.compute(6,(key,value) ->  null));//null -》返回值为null，则删除该key值
        System.out.println(map.toString());//{0=val_0, 1=val_1, 2=val_2, 3=3:val_3, 4=val_4, 5=val_5, 10=666666, 11=val_11}
        /** 8:
         * merge(K key, V value,BiFunctionsuper V, ? super V, ? extends V> remappingFunction):
         * 功能大部分与compute相同，不同之处在于BiFunction中apply的参数，入参为oldValue、value，
         * 调用merge时根据两个value进行逻辑处理并返回value。
         */
        System.out.println(map.merge(3,"val_3",(value,newValue) -> newValue));//val_3  --》返回值覆盖原来的value
        System.out.println(map.merge(10,"33334",(a,b) -> (Integer.valueOf(a)+Integer.valueOf(b))+""));//700000
        System.out.println(map.merge(8,"88",(oldValue,newValue) -> oldValue+newValue));//88 -》key不存在则新增
        System.out.println(map.merge(11,"11",(old,newValue) -> null));//null -》返回值为null,删除该节点
        System.out.println(map.toString());//{0=val_0, 1=val_1, 2=val_2, 3=val_3, 4=val_4, 5=val_5, 8=88, 10=700000}
        /** 9:
         * computeIfAbsent(K key,Functionsuper K, ? extends V> mappingFunction):
         * 根据key做匹配Node，（匹配不到则新建然后重排）
         * 如果Node有value，则直接返回oldValue，
         * 如果没有value则根据Function接口的apply方法获取value，返回value。
         * Function接口的apply的入参为key，调用computeIfAbsent时重写Function接口可以根据key进行逻辑处理，
         * apply的返回值即为要存储的value。
         */
        System.out.println("----------------------computeIfAbsent------------------------");
        map.put(8,null);
        System.out.println(map.toString());//{0=val_0, 1=val_1, 2=val_2, 3=val_3, 4=val_4, 5=val_5, 8=null, 10=700000}
        System.out.println(map.computeIfAbsent(0,key -> key+"000"));//val_0  -》key值存在，直接返回oldValue
        System.out.println(map.computeIfAbsent(7,key -> "value_"+key));//value_7 -》key匹配不到，直接新增，返回值为value
        System.out.println(map.computeIfAbsent(8,key -> "88"));//88 -》key匹配到了，value为null，返回值作为value
        System.out.println(map.toString());//{0=val_0, 1=val_1, 2=val_2, 3=val_3, 4=val_4, 5=val_5, 7=value_7, 8=88, 10=700000}
        /** 10:
         * V computeIfPresent(K key,BiFunction remappingFunction)：
         * 根据key做匹配，如果匹配不上则返回null,匹配上根据BiFunction的apply方法获取value，返回value。
         * BiFunction接口的apply的入参为key、oldValue，调用computeIfPresent时重写Function接口
         * 可以根据key和oldValue进行逻辑处理，apply的返回值如果为null则删除该节点，否则即为要存储的value。
         */
        map.remove(7);
        map.remove(8);
        map.replace(10,null);
        map.remove(0,"val_0");//value匹配到了删除
        map.remove(1,"val_0");//value匹配失败，不会删除
        System.out.println(map.toString());//{1=val_1, 2=val_2, 3=val_3, 4=val_4, 5=val_5, 10=null}
        System.out.println(map.computeIfPresent(3,(key,value) -> key+":"+value));//3:val_3 -》key存在，根据返回值修改value
        System.out.println(map.computeIfPresent(0,(key, value) -> "0000"));//null -》key不存在，返回null,不做任何操作
        System.out.println(map.computeIfPresent(1,(key, value) -> null));//null -》key存在，根据返回值修改value
        System.out.println(map.computeIfPresent(10,(key,value) -> "val_10"));//null -》oldValue值为null，删除节点
        System.out.println(map.toString());//{2=val_2, 3=3:val_3, 4=val_4, 5=val_5, 10=null}
        /** 比较
         * compute：根据key做匹配，key,value为参数，匹配到Node做value替换，匹配不到新增node。apply的返回值为null则删除该节点。
         * merge：oldValue，newValue作为为参数，其它功能于compute类似
         * computeIfAbsent：根据key匹配，参数为key,存在且value不为null，不做修改，为null用返回值作为value，不存在则新增
         * computeIfPresent：key,value作为参数，存在,原来的值为null不做操作，否则返回值作为新的value覆盖原来；不存在，不做操作；返回值为null删除该节点
         *
         */
        /*------------------------------------------------------------------*/
//        getOrDefault();
//        forEach();
//        putIfAbsent();
    }

    private static void putIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.putIfAbsent("a", "ztyj");
        System.out.println(map.get("a")); //A
        map.putIfAbsent("a1", "zsw");
        System.out.println(map.get("a1"));// zsw
    }

    private static void forEach() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    private static void getOrDefault() {
        HashMap<String, String> map = new HashMap<>();
        map.put("d", "zytj");
        String orDefault = map.getOrDefault("d1", "zsw");
        String orDefault2 = map.getOrDefault("d", "zsw");
        System.out.println(orDefault); //zsw
        System.out.println(orDefault2); // ztyj
    }
    // list集合转map
//    Map<Long, ItemTemplate> longItemTemplateMap =
//            listOnionScrumResult.getData().stream().collect(Collectors.toMap(ItemTemplate::getIdxCode, ItemTemplate -> ItemTemplate));

}
