package DataStructure.BinarySearchTree;

import java.security.Key;

/**
 *  author white tea
 */
public class BinarySearchTree {
    //跟节点
    private Node mRoot;
    //计数，记录数量的值，每插入一个就应该数据增加1
    private int mCount;
    //获取tree的大小
    public int getSize(){
        return mCount;
    }
    //判断是否为空，主要是通过mCount与0比较
    public boolean isEmpty(){
        return mCount==0;
    }

    /**
     * 提供给外部使用
     * @param key
     * @param value
     */
    public void insert(int key,int value){
        //调用内部的insert方法，把当前的key和value放入到以mRoot为根节点的树当中去。
        mRoot=insert(mRoot,key,value);
    }


    /**
     * 二叉树的实现方式
     * @param node
     * @param key
     * @param value
     * @return
     *
     *插入一个节点.
     *核心思想:从根节点开始找插入的位置，满足二叉搜索树的特性，比左子节点大，比右子节点小.
     *步骤：
     *  1、从根节点开始，先比较当前节点，如果当前节点为null，那么插入当前节点
     *  2、如果上面节点不是null，与当前节点比较，如果小于当前节点就往左子树放，如果大于节点就往右子树放。
     *  3、然后分别对左子树或者右子树递归进行如1与2的操作
     *
     */
    private Node insert(Node node,int key,int value){
        if(node == null){
            mCount++;
            return new Node(key,value);
        }
        if(key <node.getKey()){
            Node left=insert(node.getLeftChild(),key,value);
            node.setLeftChild(left);
        }else if(key >node.getKey()){
            Node right=insert(node.getRightChild(),key,value);
            node.setRightChild(right);
        }else{
            node.setValue(value);
        }
        return node;
    }
    /**
     *  根据键值来找对应的value。
     * @param key 要进行查找的key
     * @return 返回key对应的value,如果查找失败返回null。
     *
     */
    public int serch(int key){
        //调用内部函数递归的进行。
        return serch(mRoot,key);
    }
    /**
     *
     * @param node 第一开始传入的是根节点，从根节点开始索引，搜索完后，传入的是下一个要搜索的节点。
     * @param key 要查找的键值。
     * @return 返回查找的key对应的value.
     */
    private int serch(Node node,int key){
        //证明没有找到,直接返回未找到时候的处理
        if(node == null){
            return (Integer) null;//?没找到返回什么比较好？
        }
        //下面就是依次对比要搜索的key和当前Node的key对应的值:
        //     如果相等：那证明找到了直接返回当前的值
        //     如果要搜索的key小于当前节点的key：那么去当前节点的左子节点去递归的进行搜索。
        //     如果要搜索的key大于当前节点的key：那么去当前节点的右子节点去递归的进行搜索。
        if(node.getKey() == key){
            return node.getValue();
            //看它这样子key是唯一并且右边的key也大于左边？你没有猜错，哈哈哈，一开始理解错了，图里
            //面都是key的值不是value
        }else if (key < node.getKey()){
            //左侧处理,继续处理左子节点的数,找到后就直接返回。(此处理解的还是不太好)
            //此处这个函数就可以返回了，直接进入到下一个函数递归去查找了，这个函数的返回值就是一
            //下一个函数的返回值，如此递归下去。
            return serch(node.getLeftChild(), key);
        }else{
            return serch(node.getRightChild(), key);
        }
    }

    /**
     * 判断当前的key对应的键值对是否存在二叉搜索树中
     * @param key 要查找的key
     * @return 存在返回true,不存在返回false.
     */
    public boolean contain(int key){
        return contain(mRoot,key);
    }
    //实现思路和搜索一样，毕竟看看有没有在其实就是搜索的过程
    private boolean contain(Node node,int key){
        if(node==null){
            return false;
        }
        if(node.getKey() == key){
            return true;
            //看它这样子key是唯一并且右边的key也大于左边？
        }else if (key < node.getKey()){
            //左侧处理,继续处理左子节点的数,找到后就直接返回。(此处理解的还是不太好)
            return contain(node.getLeftChild(), key);
        }else{
            return contain(node.getRightChild(), key);
        }
    }
    /**
     * 前序遍历
     * 遍历这块就用递归的思想很容易实现，那么最小的规模就是对一个节点,函数应该带有参数Node.
     */
    public void perTravelsal(){
        //从根节点开始遍历
        perTravelsal(mRoot);
    }

    private void perTravelsal(Node node){
        //直到节点是null就不用再往下走了
        if(node != null){
            //对于每个节点都是先遍历当前节点.
            //遍历就进行简单的打印key值吧
            System.out.print(node.getKey()+" ");
            //然后就去递归执行左子树，注意不用判断是否有，因为进去后自会判断
            perTravelsal(node.getLeftChild());
            //递归执行右子树
            perTravelsal(node.getRightChild());
        }
    }

    /**
     * 中序遍历,中序遍历的一个应用就是遍历完毕后就是有序的。
     */
    public void inorTravelsal(){
        //调用内部的递归实现.
        inorTravelsal(mRoot);
    }
    //具体的递归实现
    private void inorTravelsal(Node node){

        if(node!=null){
            //先遍历左节点
            inorTravelsal(node.getLeftChild());
            //然后当前节点
            System.out.print(node.getKey()+" ");
            inorTravelsal(node.getRightChild());
        }
    }

}
