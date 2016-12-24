package com.yhx.quickthymeleaf.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author: shipeng.yu
 * @time: 2016年12月25日 上午2:17
 * @version: 1.0
 * @since: 1.0
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple {

    private Float price;

    private String color;

    /**
     * 制造苹果,这里生成 9 只
     *
     * @return
     */
    public static List<Apple> generateApples() {
        List<Float> prices = Arrays.asList(2.5f, 1.3f, 3.2f);
        List<String> colors = Arrays.asList("red", "green", "black");

        return prices.stream().flatMap(
                p -> colors.stream().map(c -> new Apple(p, c))).collect(toList());
    }

    public static void main(String[] args) {
        System.out.println(generateApples());
    }
}
