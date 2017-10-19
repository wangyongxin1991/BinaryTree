/**
 * 
 */
package cn.tedu;

/**
 * @ClassName BTSNode
 * @Describe TODO
 * @author  wyx
 * @date 2017��10��15�� ����10:38:35
 */
public class BSTNode
{
    private int value;
    private BSTNode LeftNode, RightNode;
    /**
     * @���췽��
     */
    public BSTNode(int value, BSTNode leftNode, BSTNode rightNode)
    {
        this.value = value;
        LeftNode = leftNode;
        RightNode = rightNode;
    }

    /**
     * @���췽��
     */
    public BSTNode(int value)
    {
        super();
        this.value = value;
    }

    /**
     * @�޲ι��췽��
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
