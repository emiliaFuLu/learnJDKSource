package com.test;

import com.test.dto.FareSource;
import com.test.dto.FareTemp;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fl
 * @data: 2020-06-17 15:04
 * @description:
 **/
public class reflectTest {

    @Test
    public void test(){
        FareSource req = new FareSource();
        req.setName("asd");
        req.setType("asds");
        req.setShopId(3545661L);
        FareTemp fareTemp = copyBean(req, FareTemp.class);

    }

    /**
     * Description: 使用反射，完成pojo到vo的映射
     */
    public static <T> T copyBean(Object source, Class<T> target){
        try {
            //获取pojo的类对象
            Class<?> sourceClass = source.getClass();
            //初始化要返回的vo对象
            T targetInstance = target.newInstance();
            return copyBean(source,targetInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T copyBean(Object source, T target){
        try {
            //获取pojo的类对象
            Class<?> sourceClass = source.getClass();
            Class<?> targetClass = target.getClass();
            //获取两者的字段
            Field[] sourceFields = getAllFields(sourceClass);
            Field[] targetFields = getAllFields(targetClass);
            //遍历替换
            for (Field sourceField : sourceFields) {
                for (Field targetField : targetFields) {
                    if (sourceField.getName().equalsIgnoreCase(targetField.getName())){
                        copyField(sourceField,targetField,source,target);
                    }
                }
            }
            //返回结果
            return target;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: yuyong
     * Date: 2018/3/23 下午3:51
     * Description: list结构的pojo到vo的映射
     */
    public static <T1,T2> List<T2> copyList(List<T1> pojoList, Class<T2> voClass){
        //初始化要返回的list
        List<T2> voList = new ArrayList<>();
        //遍历替换
        for (T1 pojo : pojoList) {
            T2 vo = copyBean(pojo, voClass);
            voList.add(vo);
        }
        //返回结果
        return voList;
    }

    /**
     * Author: yuyong
     * Date: 2018/3/23 下午3:43
     * Description: 复制字段的值
     */
    public static void copyField(Field pojoField, Field voField, Object pojo, Object vo){
        try {
            //获取pojo数据字段的值
            pojoField.setAccessible(true);
            Object value = pojoField.get(pojo);
            //给目标数据字段赋值
            voField.setAccessible(true);
            voField.set(vo, value);
            //访问权限还原
            pojoField.setAccessible(false);
            voField.setAccessible(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Author: yuyong
     * Date: 2018/4/26 下午8:17
     * Description: 获取包括父类所有字段
     */
    public static Field[] getAllFields(Class clas){
        List<Field> fieldList = new ArrayList<>();
        while (clas != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(clas.getDeclaredFields()));
            clas = clas.getSuperclass(); //得到父类,然后赋给自己
        }
        return fieldList.toArray(new Field[0]);
    }
}
