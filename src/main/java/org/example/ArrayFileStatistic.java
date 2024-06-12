package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Максимальне число в файлі
//Мінімальне число в файлі
//Медіану
//Середнє арифметичне значення
//Найбільшу послідовність чисел (які ідуть один за одним), яка збільшується (опціонально)
//Найбільшу послідовність чисел (які ідуть один за одним), яка зменшується (опціонально)
public class ArrayFileStatistic {


    private List<Long> arrayList=new ArrayList<>();

    private List<Long> sortedList=new ArrayList<>();
    public ArrayFileStatistic(BufferedReader bufferedInputStream){
        String line;
        try(bufferedInputStream){
            while ((line=bufferedInputStream.readLine())!=null){
                arrayList.add(Long.parseLong(line));
            }
            sortedList=arrayList.stream().sorted().collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public long getMaxNumber(){

        return sortedList.get(arrayList.size()-1);
    }

    public long getMinNumber(){

        return sortedList.get(0);
    }

    public double getAverage(){
        long sum=arrayList.stream().mapToLong(Long::longValue).sum();
        return sum/arrayList.size();
    }
    public double getMediana(){
        double median;
        if (sortedList.size() % 2 == 0) {
            median = (sortedList.get(sortedList.size() / 2 - 1) + sortedList.get(sortedList.size() / 2)) / 2.0;
        } else {
            median = sortedList.get(sortedList.size() / 2);
        }
        return median;
    }

    public List<Long> findLongestIncreasingSequence() {
        List<Long> longestSequence = new ArrayList<>();
        List<Long> currentSequence = new ArrayList<>();

        for (int i = 0; i < arrayList.size() - 1; i++) {
            currentSequence.add(arrayList.get(i));
            if (arrayList.get(i) >= arrayList.get(i + 1)) {
                if (currentSequence.size() > longestSequence.size()) {
                    longestSequence = new ArrayList<>(currentSequence);
                }
                currentSequence.clear();
            }
        }
        currentSequence.add(arrayList.get(arrayList.size() - 1));
        if (currentSequence.size() > longestSequence.size()) {
            longestSequence = new ArrayList<>(currentSequence);
        }

        return longestSequence;
    }

    public List<Long> findLongestDecreasingSequence() {
        List<Long> longestSequence = new ArrayList<>();
        List<Long> currentSequence = new ArrayList<>();

        for (int i = 0; i < arrayList.size() - 1; i++) {
            currentSequence.add(arrayList.get(i));
            if (arrayList.get(i) <= arrayList.get(i + 1)) {
                if (currentSequence.size() > longestSequence.size()) {
                    longestSequence = new ArrayList<>(currentSequence);
                }
                currentSequence.clear();
            }
        }
        currentSequence.add(arrayList.get(arrayList.size() - 1));
        if (currentSequence.size() > longestSequence.size()) {
            longestSequence = new ArrayList<>(currentSequence);
        }

        return longestSequence;
    }

}
