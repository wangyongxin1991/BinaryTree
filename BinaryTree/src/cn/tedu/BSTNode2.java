/**
 * 
 */
package cn.tedu;

/**
 * @ClassName BTSNode
 * @Describe �����У��ڵ��Ӧ��ֵ�߱��ɱȽ��Ի����ڹ�����ʱ��������бȽ��ԣ��������������е�ֵ���бȽ���  
 * @author  wyx
 * @date 2017��10��15�� ����10:38:35
 */
public class BSTNode2<T extends Comparable<? super T>>
{
    private T value;
    private BSTNode2<T> LeftNode, RightNode;
    /**
     * @���췽��
     */
    public BSTNode2(BSTNode2<T> leftNode, T value, BSTNode2<T> rightNode)
    {
        this.LeftNode = leftNode;
        this.setValue(value);
        this.RightNode = rightNode;
    }

    /**
     * @���췽��
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
