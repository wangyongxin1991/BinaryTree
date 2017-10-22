/**
 * 
 */
package cn.tedu;

/**
 * @ClassName BTSNode
 * @Describe 在树中，节点对应的值具备可比较性或者在构造树时树本身具有比较性，这里假设插入书中的值具有比较性  
 * @author  wyx
 * @date 2017年10月15日 下午10:38:35
 */
public class BSTNode2<T extends Comparable<? super T>>
{
    private T value;
    private BSTNode2<T> LeftNode, RightNode;
    /**
     * @构造方法
     */
    public BSTNode2(BSTNode2<T> leftNode, T value, BSTNode2<T> rightNode)
    {
        this.LeftNode = leftNode;
        this.setValue(value);
        this.RightNode = rightNode;
    }

    /**
     * @构造方法
     */
    public BSTNode2()
    {
    }

    public BSTNode2<T> getLeftNode()
    {
        return LeftNode;
    }
    public void setLeftNode(BSTNode2<T> leftNode)
    {
        LeftNode = leftNode;
    }
    public BSTNode2<T> getRightNode()
    {
        return RightNode;
    }
    public void setRightNode(BSTNode2<T> rightNode)
    {
        RightNode = rightNode;
    }

    public T getValue()
    {
        return value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }
}
