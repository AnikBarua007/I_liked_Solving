// code by ANIK BARUA
// 9.22.2022
//just trying to find out the the middle between two times
//caution--
//this is probably not efficient and but it was fun to make it work.....
#include<stdio.h>
#include<stdlib.h>
int main()
{
   int hour1,hour2,minute1,minute2,minutes,total;
   scanf("%d:%d",&hour1,&minute1);
   scanf("%d:%d",&hour2,&minute2);

    //i calculated the minutes between the times and added it to the starting time....

 if(hour1==hour2){
   minutes=(minute2-minute1)/2;
   printf("%.2d:%.2d",hour1,minute1+minutes);  //if hours are same then just calculate the minutes in between and 
                                               //add to the starting time
    }
 if(hour1<hour2)
 {
   if(minute1>minute2)
     {
        minutes=((minute2+60)-minute1+60*(hour2-hour1-1))/2; //if staring times minute count is bigger than the
        //other one then add 60 minutes to the hour2 and minus it from minute1....also counting the hours in between
         total=minute1+minutes;
        while((total)>=60)
        {

          total=total-60;//if minute count goes above 60 then increas hour reducing minutes by 60 mins...
          hour1++;
        }
        printf("%.2d:%.2d",hour1,total);//print the total
      }
      if(minute2>minute1)
      {
      minutes=((minute2+60)-minute1+60*(hour2-hour1-1))/2;//first and second one could have been merged togather and 
      //wasnt thinking it at all
      total=minute1+minutes;
      while((total)>=60)
        {
          total=total-60;
          hour1++;
        }
        printf("%.2d:%.2d",hour1,total);
      }
      if(minute1==minute2)
      {
          minutes=((hour2-hour1)*60)/2;  //in similarity this is when both minues are equal
          //now i can merge them and making it way more easy to write but this is fine tooo.....
      total=minute1+minutes;
     while((total)>=60)
        {
          total=total-60;
          hour1++;
        }
        printf("%.2d:%.2d",hour1,total);
      }
}
return 0;
}
