package com.line.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @desc json转换工具类，针对第二层对象无法转换问题
 * @Author xw
 * @Date 2019/9/19
 */
public class JsonConvertUtils {

    // com.alibaba.fastjson.JSONArray

    /*public static <T> List<T> getList(List<T> data, Class<T> t) {
        return JSONArray.parseArray(JSONArray.toJSONString(data),t);
    }

    public static <T> T getFirst(List<T> data, Class<T> t) {
        return Optional.ofNullable(getList(data, t)).map(m -> m.get(0)).orElse(null);
    }*/
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(list.size());
        list.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // Set<Entry>转换为Stream<Entry>
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList()); // 转化为 List
        System.out.println(list);
    }
}
