//hackerrank
//https://www.hackerrank.com/challenges/best-divisor/problem?isFullScreen=true
//Anik Barua________10.21.2022________________________________________________
#include <bits/stdc++.h>
using namespace std;
int Best_Divisors_is(vector<int>divisors){
 int sum=0,bestsum=0,last_digit;
 //i am assigning the sum of the first numbers digits to the best sum
 //intention is to compare it to the next eliments
 int n=divisors[0];
		while(n!=0){
			 last_digit=n%10;
			sum=sum+last_digit;
			n=n/10;
				}
	bestsum=sum;
	int bestdivisor=divisors[0];
	sum=0;
	//comapring it and at the end i'll get my bestsum and returning it back
	for(int i=1;i<divisors.size();i++){
	    n=divisors[i];
		while(n!=0){
	   last_digit=n%10;
		sum=sum+last_digit;
		n=n/10;
		}
		if(sum>bestsum){
			bestsum=sum;
			bestdivisor=divisors[i];
		}
		else if(sum==bestsum){
		 //this is if sum of digits are same then the lower number will be the best
		 //just doing that
		  bestdivisor=(divisors[i]<divisors[i-1])?divisors[i]:divisors[i-1];
		}
		sum=0;
	}
	return bestdivisor;
}

int main(){
    int n;
  	vector<int>divisors;
  	cin>>n;
  	int i=1;
  	while(i<=n){
  		if(n%i==0){
  			divisors.push_back(i);//i am trying to get the divisors and put them 
  								  //in a vector of integers
  		}
  		i++;
  	}
  	int bestdivisor=Best_Divisors_is(divisors);//calling the fuction and printing it next line
  	cout<<bestdivisor<<endl;
}

/*
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n;
    cin >> n;
    int best = -1, ans = 1;
    for (int i = 1; i <= n; i++) {
        if (n % i != 0) {
            continue;
        }
        int s = 0;
        int x = i;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        if (s > best) {
            best = s;
            ans = i;
        }
    }
    cout << ans << endl;
    return 0;
}
*/