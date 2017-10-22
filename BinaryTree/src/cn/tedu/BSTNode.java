/**
 * 
 */
package cn.tedu;

/**
 * @ClassName BTSNode
 * @Describe TODO
 * @author  wyx
 * @date 2017年10月15日 下午10:38:35
 */
public class BSTNode
{
    private int value;
    private BSTNode LeftNode, RightNode;
    /**
     * @构造方法
     */
    public BSTNode(int value, BSTNode leftNode, BSTNode rightNode)
    {
        this.value = value;
        LeftNode = leftNode;
        RightNode = rightNode;
    }

    /**
     * @构造方法
     */
    public BSTNode(int value)
    {
        super();
        this.value = value;
    }

    /**
     * @无参构造方法
     */
    public BSTNode()
    {
        super();
    }

    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public BSTNode getLeftNode()
    {
        return LeftNode;
    }
    public void setLeftNode(BSTNode leftNode)
    {
        LeftNode = leftNode;
    }
    public BSTNode getRightNode()
    {
        return RightNode;
    }
    public void setRightNode(BSTNode rightNode)
    {
        RightNode = rightNode;
    }



}
