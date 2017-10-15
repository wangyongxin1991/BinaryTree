/**
 * 
 */
package cn.tedu;

/**
 * @ClassName BTNode
 * @Describe �������ڵ� 1
 * 
 * @author  wyx
 * @date 2017��10��12�� ����10:54:25
 */
public class BTNode
{
    //����
    private String key;
    //���ҽڵ�
    private BTNode left, right;

    /**
     * @���췽��
     */
    public BTNode(String key)
    {
        this(key, null, null);
    }

    /**
     * @���췽��
     */
    public BTNode(String key, BTNode left, BTNode right)
    {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public String getKey()
    {
        return key;
    }
    public void setKey(String key)
    {
        this.key = key;
    }
    public BTNode getLeft()
    {
        return left;
    }
    public void setLeft(BTNode left)
    {
        this.left = left;
    }
    public BTNode getRight()
    {
        return right;
    }
    public void setRight(BTNode right)
    {
        this.right = right;
    }


}
