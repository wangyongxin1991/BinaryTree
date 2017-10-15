/**
 * 
 */
package cn.tedu;

/**
 * @ClassName BTNode
 * @Describe 二叉树节点 1
 * 
 * @author  wyx
 * @date 2017年10月12日 下午10:54:25
 */
public class BTNode
{
    //数据
    private String key;
    //左右节点
    private BTNode left, right;

    /**
     * @构造方法
     */
    public BTNode(String key)
    {
        this(key, null, null);
    }

    /**
     * @构造方法
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
