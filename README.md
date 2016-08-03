# Algorithm

主要用于算法和数据结构的学习。

## 数据结构的简单实现
位于 com.limbo.stack 包里

* 以数组实现简单的可变容量的栈
* 以链表实现可迭代的栈和队列


### 数据结构分类：

* 数组（array：最基本的数据结构）
  - ArrayList：有序可重复、有索引、插入删除慢
  - 包含 resize（）方法实现可变大小
* 链表（link：基本数据结构）
  - 以一个 Node 作为内部类：包含值和对下一个节点的引用
  - LindedList：有序可重复、无索引、插入查找快
* 背包（无序，可遍历）
* 栈（先进先出：从脑袋放，从脑袋拿）
  - put() pop()一般用链表实现
* 队列（先进后出：屁股放，脑袋拿）
  - enqueue() dequeue()可以用数组或链表实现
  - 注意节点为0时的处理「first 与 last node 的关系」
* 堆——Heap
  - 底层用数组实现的二叉树：确定节点 k 与其父节点 k/2 和子节点：2k/2k+1的关系
  - swim() sink() 方法
  - 堆有序：1.构建堆 2.堆有序
* 符号表（搜索结构：Map）
  - 无序链表实现：遍历搜索
  - （键数组有序）两个数组实现：二分法搜索：核心 rank（）方法-返回所查找键在数组中排第几（不论是否找到该键）
  - 二叉树实现：普通二叉树、红黑树
* 散列表——HashTable
* 树（二叉树/红黑树——TreeMap）
  - 二叉查找树（可以保持键的有序性）：
    + 每个 Node 包含两个引用分别指向左右两个子节点（子树）、包含键和对应的值、包含一个 N 用来记录当前节点所在子树的节点总数。
    + size（k）= size(k.left) + size(k.right) + 1 。
    + 搜索：二分法，检查被查找键值与当前节点左右子节点键值的大小，据此递归的向左（右）节点进入继续查找, 当递归至 x==null 的节点时，表示未命中。
    + get() put()： 注意 put 方法返回值是 node，因为当查找未命中时，会在最底层新建结点，需要进行更新（包括 N）
    + 删除操作：递归的找到待删除节点——>如果该节点有一边子树为空，则令其父节点指向非空子树。——>如果待删除该节点存在两个子树，则用其右子树的最小节点代替之。
    + 运行时间取决于树的形状：所以需要红黑树。


##算法的简单实现：


* 排序（com.limbo.sort）
  - 选择排序
    + 运行时间和输入无关（总要扫描一遍数组，而无法利用数组已有的信息）
    + 移动数据是最小的（N）
  - 插入排序
    + 适用于非随机数组
    + 改进：在内循环时使较大元素右移一位，而不是交换两个元素，这样访问数组的次数就能减半。
  - 希尔排序
  - 归并排序
    + 主要缺点：空间复杂度为 n
  - 快速排序
  - 堆排序
* 查找(com.limbo.search)
  - 无序链表中的顺序查找
  - 有序数组中的二分查找
  - 基本二叉树查找
  - 红黑二叉树查找

* 增加 KMP 算法的学习：[KMP 算法详解](http://blog.csdn.net/v_july_v/article/details/7041827)
