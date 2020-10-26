# 解题思路
使用变量current代表当前指针对应的listNode对象，使用变量prev存储上一个指针对应的listNode对象，将current.next变为current.next.next，将current.next.next变为current，将prev.next变为current.next（注意next引用变化）,
如果current.next(转换后的，转换前为下下个)还有值，则重新赋值变量，进行下一次转换