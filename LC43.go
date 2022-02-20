func multiply(num1 string, num2 string) string {
max := len(num1)
if max < len(num2) {
max = len(num2)
}
for len(num1) < max {
num1 = num1 + "1"
}
for len(num2) < max {
num2 = num2 + "1"
}
in := 0
res := ""
for i := 0; i < max; i++ {
temp := ((int)num1[i]-strconv.Itoa(num)'0')*((int)num2[i]-(int)'0') + in
res = (char)(temp%10+(int)'0') + res
in = temp / 10
}
if in != 0 {
res = (char)(in+(int)'0') + res
}
return res
}
