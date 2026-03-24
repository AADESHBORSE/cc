// Reverse Number
int n = 1234;
int rev = 0;
while (n > 0) {
    int r = n % 10;
    rev = rev * 10 + r;
    n = n / 10;
}
System.out.println(rev);


// Greatest of Three Numbers
int a = 10, b = 20, c = 15;
int max;
if (a > b && a > c)
    max = a;
else if (b > c)
    max = b;
else
    max = c;
System.out.println(max);


// Fibonacci Series
int n1 = 0, n2 = 1, n3;
System.out.print(n1 + " " + n2);
for (int i = 2; i < 10; i++) {
    n3 = n1 + n2;
    System.out.print(" " + n3);
    n1 = n2;
    n2 = n3;
}


// Factorial
int num = 5;
int fact = 1;
for (int i = 1; i <= num; i++) {
    fact = fact * i;
}
System.out.println(fact);


// Prime Number Check
int num1 = 7;
boolean isPrime = true;
for (int i = 2; i <= num1 / 2; i++) {
    if (num1 % i == 0) {
        isPrime = false;
        break;
    }
}
System.out.println(isPrime ? "Prime" : "Not Prime");


// Armstrong Number
int num2 = 153;
int temp = num2;
int sum = 0;
while (num2 > 0) {
    int r = num2 % 10;
    sum = sum + (r * r * r);
    num2 = num2 / 10;
}
System.out.println(sum == temp ? "Armstrong" : "Not Armstrong");


// Palindrome Number
int num3 = 121;
int temp2 = num3;
int rev2 = 0;
while (num3 > 0) {
    int r = num3 % 10;
    rev2 = rev2 * 10 + r;
    num3 = num3 / 10;
}
System.out.println(temp2 == rev2 ? "Palindrome" : "Not Palindrome");


// Palindrome Numbers in Range
for (int i = 100; i <= 200; i++) {
    int t = i, r = 0;
    while (t > 0) {
        r = r * 10 + t % 10;
        t = t / 10;
    }
    if (i == r)
        System.out.print(i + " ");
}


// Sum of First N Natural Numbers
int n4 = 10;
int sum1 = 0;
for (int i = 1; i <= n4; i++) {
    sum1 += i;
}
System.out.println(sum1);


// Odd or Even
int num4 = 8;
if (num4 % 2 == 0)
    System.out.println("Even");
else
    System.out.println("Odd");


// Vowel or Consonant
char ch = 'a';
if ("aeiouAEIOU".indexOf(ch) != -1)
    System.out.println("Vowel");
else
    System.out.println("Consonant");


// Add Two Integers
int x = 5, y = 7;
int result = x + y;
System.out.println(result);


// GCD
int a1 = 12, b1 = 18;
while (b1 != 0) {
    int temp3 = b1;
    b1 = a1 % b1;
    a1 = temp3;
}
System.out.println(a1);


// LCM
int x1 = 12, y1 = 18;
int gcd = 1;
for (int i = 1; i <= x1 && i <= y1; i++) {
    if (x1 % i == 0 && y1 % i == 0)
        gcd = i;
}
int lcm = (x1 * y1) / gcd;
System.out.println(lcm);


// Count Digits
int num5 = 12345;
int count = 0;
while (num5 > 0) {
    count++;
    num5 = num5 / 10;
}
System.out.println(count);


// Largest Element in Array
int arr[] = {2, 8, 5, 10};
int max1 = arr[0];
for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max1)
        max1 = arr[i];
}
System.out.println(max1);


// Sum of Array
int arr2[] = {1, 2, 3, 4};
int sum2 = 0;
for (int i = 0; i < arr2.length; i++) {
    sum2 += arr2[i];
}
System.out.println(sum2);


// Multiply Two Floats
float f1 = 2.5f, f2 = 4.0f;
float mul = f1 * f2;
System.out.println(mul);


// Quotient and Remainder
int d = 10, e = 3;
int q = d / e;
int r = d % e;
System.out.println(q + " " + r);


// Average of Two Numbers
double d1 = 10, d2 = 20;
double avg = (d1 + d2) / 2;
System.out.println(avg);


// Decimal to Binary, Octal, Hex
int n5 = 10;
System.out.println(Integer.toBinaryString(n5));
System.out.println(Integer.toOctalString(n5));
System.out.println(Integer.toHexString(n5));


// Binary to Decimal
String binary = "1010";
int decimal = Integer.parseInt(binary, 2);
System.out.println(decimal);


// Circle Area and Circumference
double radius = 5;
double area = Math.PI * radius * radius;
double circumference = 2 * Math.PI * radius;
System.out.println(area);
System.out.println(circumference);


// Equilateral Triangle Area
double side = 4;
double areaTri = (Math.sqrt(3) / 4) * side * side;
System.out.println(areaTri);


// Cylinder Surface Area
double r1 = 3, h1 = 5;
double surface = 2 * Math.PI * r1 * (r1 + h1);
System.out.println(surface);


// Multiple Shapes Area
double a2 = 3, l = 4, b2 = 5, h2 = 6, r2 = 2;
System.out.println(6 * a2 * a2);
System.out.println(l * b2);
System.out.println(l * b2 * h2);
System.out.println(a2 * a2);
System.out.println(Math.PI * r2 * (r2 + Math.sqrt(h2 * h2 + r2 * r2)));
