# MissionData

I took HashMap object to have users and amounts they spent in Key-Value pairs.

I took example of Splitwise money distribution as an example .

When I divided the whole amount the total number of users and if the result is decimal I tried to round it into 2 decimal points using DecimalFormat Java object this some times gives values which end up in getting few extra cents or loosing some cents .

For example user1:25 ,user2:10,user3:9 the total amount is 44 then 44/3=14.66666 DecimalFormat object gave 14.67 which increases the total figure by 0.01$(1 cent).

In another case user1:25 ,user2:9,user3:9 the total is 43 43/3=14.3333 rounded value by DecimalFormat gave 14.33 which decreased by 1 cent (0.01$).

Hence I used some simple math to find number of cents lost and gained and I adjusted this using flag to keep count of number of cents lost or added .I looked into splitwise it showed difference in cents randomly so therefore I used set object(no order) to adjust this cents to the values.

I used HashMap  String,Double  Key-Value pairs as input and I returned  HashMap  String,String   Key-Value pairs  as output in order to concatenate $ sign before the values.


Please see the test file 
1.First run as it is 
2.Secondly uncomment the above lines and comment the below 3 input lines

It should cover both cases

Please let me know if there is any scope for improvement in my code. I guess keeping track of every cent after rounding up to decimal places is the important part in this test .I took care of this by taking some random values and figured out the logic.


