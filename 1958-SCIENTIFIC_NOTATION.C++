// code by anik barua
// 9.28.2022
//  3.1234        E  0
//  5656656565656 E 13

//1958 - Scientific Notation

#include <bits/stdc++.h>
using namespace std;

int main()
{
     long double x;
      long double ami;
    cin >> x;
    
    ami=x;
    int count = 0;
    if (x < 0)
    {
        if (x > -1)
        {
            //-0.001
            while ((int)x == 0)
            {
                count++;
                x = x * 10;
            }
            printf("%.4Lf",ami*(pow(10,(count))));
            cout<<"E";
            cout<<"-";
            printf("%.2d",count);
            cout<<endl;
        }
        ///////////////////////////////////
        /////
        else
        {
            //-466.77
            while ((int)x != 0)
            {
                count++;
                x = x / 10;
            }
            printf("%.4Lf",ami/(pow(10,(count-1))));
            cout<<"E";
            cout<<"+";
            printf("%.2d",count-1);
            cout<<endl;
            
        }
    }
    else if (x >= 0)
    {
        if (x < 0)
        {
            // 0.001
            while ((int)x == 0)
            {
                count++;
                x = x * 10;
            }
            printf("+%.4Lf",ami*(pow(10,(count))));
            cout<<"E";
            cout<<"-";
            printf("%.2d",count);
            cout<<endl;
        }
        else
       {
         //566.77
            while ((int)x != 0)
            {
                count++;
                x = x / 10;
            }
            printf("+%.4Lf",ami/(pow(10,(count-1))));
            cout<<"E";
            cout<<"+";
            printf("%.2d",count-1);
            cout<<endl;
        }
    }
    return 0;
}