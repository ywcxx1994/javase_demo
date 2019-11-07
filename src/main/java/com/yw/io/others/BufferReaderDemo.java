package com.yw.io.others;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  BufferedReader 使用demo
 *
 * Created by 18765 on 2019/11/6 19:38
 */
public class BufferReaderDemo {
    public static void main(String[] args) throws Exception {
//        String line2 = "Log4j:[2019-11-06 11:15:24]  INFO WXChargeOrderProcessController:437 - 充值的接口返回报文wxChargeOrderProcess:请求序列号为:3b71f27eeb9951da93520ef1f78b6b54的报文:{\"body\":{\"code\":\"200\",\"order_id\":\"242FC1573010124209101856\",\"msg\":\"操作成功\"},\"header\":{\"sign\":\"RdQDGCxUy55Q3IQGL+rV07ukD5yr7miHxcG1pS6ohr3NusEaXxPlpKrDR30NpSNMK5uI8W63xZff9zlo9GOn3OcoTguoydkqQ8aX4IFr+AGjHqcmR0Q0yzRk3iVZazebZcy/VSzla3zLM9Oghl0ynjOnrrSmLNiqKG7gimaAQsk=\",\"sign_nonce\":\"1573010128761\",\"timestamp\":\"1573010124214\",\"req_no\":\"3b71f27eeb9951da93520ef1f78b6b54\",\"app_id\":\"2018091908550\"}}";
//        String line = "Log4j:[2019-11-06 11:16:03]  INFO WXChargeOrderProcessController:67 - 充值的接口接收报文wxChargeOrderProcess:{\"body\":{\"ext_content\":\"\",\"kh_order_id\":\"30119110349682043716304906\",\"phone\":\"13698734476\",\"product_id\":\"CM100\",\"type\":\"1\"},\"header\":{\"app_id\":\"2018091908550\",\"req_no\":\"94e341f343ce820fc955feffff81398a\",\"sign\":\"fVzQnMyJm74y7AhNfWhaj/o9N0GR0VxHuhl+PSv9bqbSIRMwtLV52fes0fN8s5mGSKTgg0cU0qRyNNELeSpoS5eLmLIWD5mDR02u9uxFRbZE9f7o/jw907BWKf4B10xiRXNvPrPqIguHEbla87e89HTmMsYfUvuuO67UBSmyTdI=\",\"sign_nonce\":\"1573010167669\",\"timestamp\":\"1573010167669\"}}";
//        Map mapTypes = JSON.parseObject(line.substring(line.indexOf("{")));
//        Map map = (Map)mapTypes.get("header");
//        System.out.println(map.get("req_no"));
        BufferReaderDemo.test();
    }

    public static void test() throws Exception{
        List<Map<String,String>> list = new ArrayList();
        Map<String,String> finalResult = new HashMap<>();
        Map<String,Map<String,String>> reqMap = new HashMap<>();
        Map<String,String> rspMap = new HashMap<>();
        FileReader fr=new FileReader("D:\\1.log");
        BufferedReader br=new BufferedReader(fr);
        String line="";
        while ((line=br.readLine())!=null) {
            if(line.contains("kh_order_id")){
                Map mapTypes = JSON.parseObject(line.substring(line.indexOf("{")));
                Map body = (Map)mapTypes.get("body");
                Map header = (Map)mapTypes.get("header");
                String req_no = (String)header.get("req_no");
                reqMap.put(req_no,body);
            }
            if(line.contains("order_id")){
                Map mapTypes = JSON.parseObject(line.substring(line.indexOf("{")));
                Map body = (Map)mapTypes.get("body");
                String order_id = (String)body.get("order_id");
                Map header = (Map)mapTypes.get("header");
                String req_no = (String)header.get("req_no");
                rspMap.put(req_no,order_id);
            }
        }
        for (Map.Entry<String, String> entry : rspMap.entrySet()) {
            Map<String, String> stringStringMap = reqMap.get(entry.getKey());
            if(stringStringMap != null){
                finalResult.putAll(stringStringMap);
                finalResult.put("order_id",entry.getValue());
                list.add(finalResult);
            }

        }
        for (int i = 0; i < list.size(); i++) {
            for (Map.Entry<String, String> entry : list.get(i).entrySet()) {
                System.out.println(entry.getValue());
            }
        }

        br.close();
        fr.close();
    }
}
