import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
       
        int answer = 0;
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        
        PriorityQueue<Job> wait = new PriorityQueue<>((a,b)->a.work-b.work);
        int idx = 0;
        int now =  0;
        while(idx<jobs.length){
            
            //현재 작업을 수행할 수 있으면
            if(jobs[idx][0]<=now){
                wait.add(new Job(jobs[idx][0],jobs[idx][1]));
                idx++;
                while(!wait.isEmpty()&&idx<jobs.length&&now<jobs[idx][0]){
                    Job waitJob = wait.poll();
                    now += waitJob.work;
                    answer += now - waitJob.start;
                }
            }
            //현재 작업을 수행할 수 없으면
            else{
                //큐가 비어있다면 그냥 대기
                if(wait.isEmpty()) now = jobs[idx][0];
                else{
                    while(!wait.isEmpty()&&now<jobs[idx][0]){
                        Job waitJob = wait.poll();
                        now += waitJob.work;
                        answer += now - waitJob.start;
                    }
                }
                wait.add(new Job(jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            
            
        }
        
        while(!wait.isEmpty()){
            Job waitJob = wait.poll();
            now += waitJob.work;
            answer += now - waitJob.start;
        }
        
        return (int)Math.floor(answer/jobs.length);
    }
}

class Job{
    int start, work;
    Job(int start, int work){
        this.start = start;
        this.work = work;
    }
}