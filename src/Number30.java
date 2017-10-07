import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by byhieg on 2017/9/6.
 * Mail to byhieg@gmail.com
 */
public class Number30 {


    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // write your code here
        int start = newInterval.start;
        int end = newInterval.end;
        if (intervals.size() == 0 || start <= intervals.get(0).start && end >= intervals.get(intervals.size() - 1).end) {
            ArrayList<Interval> res = new ArrayList<>();
            res.add(newInterval);
            return res;
        }

        Interval val = intervals.get(0);
        if (val.start > end) {
            intervals.add(0, newInterval);
            return sort(intervals);
        } else if (val.start == end) {
            val.start = start;
            return sort(intervals);
        }

        val = intervals.get(intervals.size() - 1);
        if (val.end == start) {
            val.end = end;
            return sort(intervals);
        } else if (val.end < start) {
            intervals.add(intervals.size() - 1, newInterval);
            return sort(intervals);
        }

        int startIndex = start;
        int prevStart = -100;
        int endIndex = end;
        int nextEnd = -100;
        for (int i = 0; i < intervals.size(); i++) {
            val = intervals.get(i);
            if(start < val.start && i == 0){
                startIndex = start;
                prevStart = start;
            }
            if (start >= val.start && start <= val.end) {

                startIndex = start;
                if (end <= val.end) {
                    return sort(intervals);
                }else{
                    prevStart = val.start;
                }
            }else if(start > val.end && i != intervals.size() - 1){
                Interval tmp = intervals.get(i + 1);
                if(start <= tmp.start){
                    prevStart = start;
                }
            }

            if (end >= val.start && end <= val.end) {
                if(end == val.start || end == val.end){
                    endIndex = val.end;
                    prevStart = start;
                }else{
                    endIndex = end;
                }
                if (start >= val.start) {
                    return intervals;
                }else{
                    nextEnd = val.end;
                    break;
                }
            }else if(end < val.start && i != 0){
                System.out.println("111");
                Interval tmp = intervals.get(i - 1);
                if(end >= tmp.end){
                    nextEnd = end;
                    break;
                }
            }

            if(end > val.end && i == intervals.size() - 1){
                endIndex = end;
                nextEnd = end;
                break;
            }


        }
        Interval newVal =  new Interval(prevStart, nextEnd);

        System.out.println("prevStart : " + prevStart);
        System.out.println("nextEnd : " + nextEnd);

        for (int i = 0; i < intervals.size(); i++) {
            val = intervals.get(i);
            if (val.start >= prevStart && prevStart != -100) {
                for (int j = i ; j < intervals.size();j++) {
                    if (intervals.get(j).end <= nextEnd) {
                        intervals.remove(intervals.get(j));
                        j--;
                    }
                }
                intervals.add(i, newVal);
                return sort(intervals);
            }
        }

        newVal = new Interval(startIndex, endIndex);
        System.out.println("startIndex : " + startIndex);
        System.out.println("endIndex : " + endIndex);
        for (int i = 0 ; i < intervals.size();i++) {
            val = intervals.get(i);
            if (val.end < startIndex) {
                intervals.add(i, newVal);
                return sort(intervals);
            }
        }

        return sort(intervals);

    }

    public ArrayList<Interval> sort(ArrayList<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        return intervals;
    }
}
