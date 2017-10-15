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
public class BTSNode
{
    private int value;
    private BTSNode LeftNode, RightNode;
    /**
     * @���췽��
     */
    public BTSNode(int value, BTSNode leftNode, BTSNode rightNode)
    {
        this.value = value;
        LeftNode = leftNode;
        RightNode = rightNode;
    }

    /**
     * @���췽��
     */
    public BTSNode(int value)
    {
        super();
        this.value = value;
    }

    /**
     * @�޲ι��췽��
     */
    public BTSNode()
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
    public BTSNode getLeftNode()
    {
        return LeftNode;
    }
    public void setLeftNode(BTSNode leftNode)
    {
        LeftNode = leftNode;
    }
    public BTSNode getRightNode()
    {
        return RightNode;
    }
    public void setRightNode(BTSNode rightNode)
    {
        RightNode = rightNode;
    }



}
