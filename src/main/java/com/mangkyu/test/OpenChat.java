package com.mangkyu.test;

import java.util.*;

// 프로그래머스 LV2 문제
public class OpenChat {
    public static void main(String[] args) {
        new OpenChat().solution(new String[]{});
    }
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        int size = record.length;
        Map<String , String> map = new HashMap<>();
        findLastName(record, map);

        for (int i = 0; i < size; i++) {
            String[] inner = record[i].split(" ");
            String cmd = inner[0];
            String uid = inner[1];
            if(!"Change".equals(cmd)) answer.add(makeMessage(cmd,map.get(uid)));
        }


        return answer;
    }

    String makeMessage(String cmd , String name) {
        StringBuilder sb = new StringBuilder();
        if("Enter".equals(cmd)) return sb.append(name).append("님이 ").append("들어왔습니다.").toString();
        else if("Leave".equals(cmd)) return sb.append(name).append("님이 ").append("나갔습니다.").toString();
        return null;
    }
    private void findLastName(String[] record, Map<String, String> map) {
        for (String s : record) {
            String[] inner = s.split(" ");
            String cmd = inner[0];
            if(!"Leave".equals(inner[0])){
                String uid = inner[1];
                String name = inner[2];
                map.put(uid,name);
            }
        }
    }
}
