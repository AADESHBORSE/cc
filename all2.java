// Swap Two Numbers (with temp)
int a = 5, b = 10;
int temp = a;
a = b;
b = temp;
System.out.println(a + " " + b);


// Swap Without Temp
int x = 5, y = 10;
x = x + y;
y = x - y;
x = x - y;
System.out.println(x + " " + y);


// Sum of Digits
int n = 1234;
int sum = 0;
while (n > 0) {
    sum += n % 10;
    n /= 10;
}
System.out.println(sum);


// Product of Digits
int n1 = 1234;
int prod = 1;
while (n1 > 0) {
    prod *= n1 % 10;
    n1 /= 10;
}
System.out.println(prod);


// Power of Number (a^b)
int base = 2, exp = 3;
int result = 1;
for (int i = 1; i <= exp; i++) {
    result *= base;
}
System.out.println(result);


// Factorial using Recursion
int fact(int n2) {
    if (n2 == 0) return 1;
    return n2 * fact(n2 - 1);
}


// Prime Numbers in Range (Optimized)
for (int i = 2; i <= 50; i++) {
    boolean prime = true;
    for (int j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
            prime = false;
            break;
        }
    }
    if (prime) System.out.print(i + " ");
}


// Strong Number
int num = 145;
int temp = num, sum1 = 0;
while (temp > 0) {
    int r = temp % 10;
    int f = 1;
    for (int i = 1; i <= r; i++) f *= i;
    sum1 += f;
    temp /= 10;
}
System.out.println(sum1 == num ? "Strong" : "Not Strong");


// Perfect Number
int num2 = 28;
int sum2 = 0;
for (int i = 1; i < num2; i++) {
    if (num2 % i == 0) sum2 += i;
}
System.out.println(sum2 == num2 ? "Perfect" : "Not Perfect");


// Binary Search
int arr[] = {1,2,3,4,5,6};
int key = 4;
int low = 0, high = arr.length - 1;
while (low <= high) {
    int mid = (low + high) / 2;
    if (arr[mid] == key) {
        System.out.println("Found");
        break;
    } else if (arr[mid] < key)
        low = mid + 1;
    else
        high = mid - 1;
}


// Linear Search
int arr2[] = {5, 3, 7, 1};
int key2 = 7;
for (int i = 0; i < arr2.length; i++) {
    if (arr2[i] == key2) {
        System.out.println("Found at " + i);
        break;
    }
}


// Bubble Sort
int arr3[] = {5, 2, 8, 1};
for (int i = 0; i < arr3.length; i++) {
    for (int j = 0; j < arr3.length - i - 1; j++) {
        if (arr3[j] > arr3[j + 1]) {
            int t = arr3[j];
            arr3[j] = arr3[j + 1];
            arr3[j + 1] = t;
        }
    }
}
for (int v : arr3) System.out.print(v + " ");


// String Reverse
String str = "hello";
String rev = "";
for (int i = str.length() - 1; i >= 0; i--) {
    rev += str.charAt(i);
}
System.out.println(rev);


// Palindrome String
String s = "madam";
String revs = "";
for (int i = s.length() - 1; i >= 0; i--) {
    revs += s.charAt(i);
}
System.out.println(s.equals(revs) ? "Palindrome" : "Not");


// Count Vowels in String
String str1 = "hello";
int count = 0;
for (int i = 0; i < str1.length(); i++) {
    if ("aeiouAEIOU".indexOf(str1.charAt(i)) != -1)
        count++;
}
System.out.println(count);


// Remove Spaces from String
String str2 = "h e l l o";
str2 = str2.replace(" ", "");
System.out.println(str2);


// Check Leap Year
int year = 2024;
if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
    System.out.println("Leap Year");
else
    System.out.println("Not Leap");


// Simple Interest
double p = 1000, r = 5, t = 2;
double si = (p * r * t) / 100;
System.out.println(si);


// Compound Interest
double principal = 1000, rate = 5, time = 2;
double ci = principal * Math.pow((1 + rate / 100), time);
System.out.println(ci);


// Min Element in Array
int arr4[] = {5, 2, 8, 1};
int min = arr4[0];
for (int i = 1; i < arr4.length; i++) {
    if (arr4[i] < min)
        min = arr4[i];
}
System.out.println(min);


// Second Largest Element
int arr5[] = {10, 20, 5, 8};
int first = 0, second = 0;
for (int v : arr5) {
    if (v > first) {
        second = first;
        first = v;
    } else if (v > second && v != first) {
        second = v;
    }
}
System.out.println(second);
