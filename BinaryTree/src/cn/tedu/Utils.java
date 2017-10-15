package cn.tedu;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
/**
 * ���й��߷������ӻ�
 * 
 * @author ������
 * 
 */
public class Utils {
    /**
      * @Method compare()
      * �Ƚ��������ζ����С 
      * ���a>b����   true 
      * ���a<b����  false
      * @return boolean
     */
    public static boolean compare(int a, int b)
    {
        if (a > b)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * 
     * @return ��ȡ23λʱ��+��λ������ı���
     */
    public static String getRandomCode()
    {
        String randomCode = null;
        SimpleDateFormat sDateFormat;
        Random r = new Random();
        int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // ��ȡ�����
        sDateFormat = new SimpleDateFormat("yyyyMMddHHmmsssss"); // ʱ���ʽ���ĸ�ʽ
        randomCode = sDateFormat.format(new Date()) + rannum;
        return randomCode;
    }
    /**
     * �������8λ�ַ�����
     * 
     * @return �������8λ�ַ���
     */
    public static String get8RandomCodeForUUID()
    {
        return UUID.randomUUID().toString().toUpperCase().substring(0, 8);
    }
    /**
     * ������������bitNumλ�ַ�����
     * @param bitNum
     *            ���뷵�ص�����λ��
     * @return �������bitNumλ�ַ���
     */
    public static String getRandomCodeForUUID(int bitNum)
    {
        return UUID.randomUUID().toString().toUpperCase().substring(0, bitNum);
    }
    /**
     * �ж��ַ����Ƿ�Ϊ�� �� �գ�false ; �ǿգ�true��
     * @param ch
     *            �����ַ���
     * @return ���
     */
    public static boolean stringIsNotEmpty(String ch)
    {
        if (ch != null && !"".equals(ch))
        {
            return true;
        } else
        {
            return false;
        }
    }
    /**
     * �ж�Object����Ϊ�� �� �գ�false ; �ǿգ�true��
     * @param obj
     *            �������
     * @return ���
     */
    public static boolean objectIsNotEmpty(Object obj)
    {
        if (obj != null && !"".equals(obj))
        {
            return true;
        } else
        {
            return false;
        }
    }
    /**
     * �ж�Object����Ϊ�� �� �գ�true; �ǿգ�false��
     * @param obj
     *            �������
     * @return ���
     */
    public static boolean objectIsEmpty(Object obj)
    {
        if (obj != null && !"".equals(obj))
        {
            return false;
        } else
        {
            return true;
        }
    }
    /**
     * �жϼ����Ƿ�Ϊ�գ� �գ�false ; �ǿգ�true��
     * @param coll
     *            ���뼯��
     * @return ���
     */
    public static boolean collectionIsNotEmpty(Collection<?> coll)
    {
        if (coll != null && coll.size() > 0)
        {
            return true;
        } else
        {
            return false;
        }
    }
    /**
     * @return ��ȡMD5�����ַ���ֵ���㷨�����档
     */
    public final static String EncodeMd5(String s)
    {
        char hexDigits[] =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest md5;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Password = md5.digest(s.getBytes());
            int j = md5Password.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++)
            {
                byte byte0 = md5Password[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @param urls  ���С�@����ϵġ������ָ��URL�ַ���
     * @return ����һ������@���������Ϣ�Ĵ��С�������URl����ַ���
     */
    public static String getUrlsValueByDeal(String urls)
    {
        if (urls != null && !"".equals(urls))
        {
            StringBuilder sb = new StringBuilder();
            String[] fileUrls = urls.split(",");
            if (fileUrls.length == 1)
            {
                sb.append(fileUrls[0].substring(0, fileUrls[0].indexOf("@")));
            } else
            {
                for (int i = 0; i < fileUrls.length; i++)
                {
                    if (i == fileUrls.length - 1)
                    {
                        sb.append(fileUrls[i].substring(0, fileUrls[i].indexOf("@")));
                    } else
                    {
                        sb.append(fileUrls[i].substring(0, fileUrls[i].indexOf("@"))).append(",");
                    }
                }
            }
            return sb.toString();
        } else
        {
            return "";
        }
    }
    /**
     * �ж�exsitsUrlsStr���Ƿ������ַdeleteURL��
     * @param exsitsUrlsStr
     *            �������url
     * @param deleteURL
     *            �������url
     * @return ���
     */
    public static boolean isFindUrl(String exsitsUrlsStr, String deleteURL)
    {
        boolean isFind = false;
        String[] exsitsUrls = exsitsUrlsStr.split(",");
        for (int i = 0; i < exsitsUrls.length; i++)
        {
            if (exsitsUrls[i].equals(deleteURL))
            {
                isFind = true;
                break;
            }
        }
        return isFind;
    }
    /**
     * �������к��ִ�Ӣ�ĵ�'�滻��" ����ͺ�sql�ĵ�'������ͻ��������Oracle
     * @param condition
     * @return 
     */
    public static String replaceSelectCharForSQL(String condition)
    {
        return condition.replaceAll("'", "''");
    }
    /**
     * ת���ַ���Ϊint ת��ʧ�ܷ���defaultVal
     * @param str
     * @param defaultVal
     * @return
     */
    public static int parseInt(String str, int defaultVal)
    {
        try
        {
            return Integer.parseInt(str);
        } catch (NumberFormatException e)
        {
            return defaultVal;
        }
    }
    /**
     * �Ѽ���ת�����ַ�������ƴ�ӷ�����ʽ�ֿ�
     * @param list  ����
     * @param str �ָ���
     * @return
     */
    /* public static String listToString(List list, String str)
    {
        if (list != null)
        {
            Object[] arrayStr = list.toArray();
            return StringUtils.join(arrayStr, ",");
        } else
        {
            return "";
        }
    }*/
    /**
     * ɾ��ԭ�е�url���еĴ����ɾ����ַdeleteURL�����������µ�URL������
     * @param fileUploadRoot ��·�����ϴ��ļ�·��������ӳ�����
     * @param exsitsUrlsStr ���ݿ���ԭ�е�url��
     * @param deleteURL �����ɾ����ַdeleteURL
     * @return
     */
    public static String getFinalUrlsString(String fileUploadRoot, String exsitsUrlsStr, String deleteURL)
    {
        String[] exsitsUrls = exsitsUrlsStr.split(",");
        String url = deleteURL.substring(0, deleteURL.indexOf("@"));
        String filePath = (fileUploadRoot + url).replace("/", "\\");
        File file = new File(filePath);
        if (file.exists())
            file.delete();//ɾ�������ļ�
        // �������ݿ��е�urlֵ
        if (exsitsUrls.length == 1)
            exsitsUrlsStr = "";
        else
        {
            StringBuilder sb = new StringBuilder();
            List<String> urlList = new ArrayList<String>();
            for (int i = 0; i < exsitsUrls.length; i++)
            {
                if (!exsitsUrls[i].equals(deleteURL))
                    urlList.add(exsitsUrls[i]);
            }
            for (int i = 0; i < urlList.size(); i++)
            {
                if (i == urlList.size() - 1)
                    sb.append(urlList.get(i));
                else
                    sb.append(urlList.get(i)).append(",");
            }
            exsitsUrlsStr = sb.toString();
        }
        return exsitsUrlsStr;
    }
}
