package com.smart.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * MD5工具类
 * 
 * @Author Sunxin
 */
public final class MD5 {
	/**
	 * 计算字符串的MD5，返回32个Hex字符的MD5结果
	 * 
	 * @param msgStr
	 * @param charset
	 * @return
	 */
	public static String md5Hex32(String msgStr, String charset) {
		byte[] msg = msgStr.getBytes(Charset.forName(charset));

		return ByteUtil.asHex(md5Byte16(msg));
	}

	/**
	 * 计算字符串的MD5，返回16个Hex字符的MD5结果
	 * 
	 * @param msgStr
	 * @param charset
	 * @return
	 */
	public static String md5Hex16(String msgStr, String charset) {
		byte[] msg = msgStr.getBytes(Charset.forName(charset));

		return ByteUtil.asHex(md5Byte8(msg));
	}

	/**
	 * 计算文件的MD5，返回32个Hex字符的MD5结果
	 * 
	 * @param file
	 * @return
	 */
	public static String md5Hex32(File file) {
		return ByteUtil.asHex(md5Byte16(file));
	}

	/**
	 * 计算文件的MD5，返回16个Hex字符的MD5结果
	 * 
	 * @param file
	 * @return
	 */
	public static String md5Hex16(File file) {
		return ByteUtil.asHex(md5Byte8(file));
	}

	/**
	 * 计算MD5，返回16字节MD5结果
	 * 
	 * @param msgStr
	 * @return
	 */
	public static byte[] md5Byte16(byte[] msg) {
		return md5(msg, false);
	}

	/**
	 * 计算MD5，返回8字节MD5结果
	 * 
	 * @param msgStr
	 * @return
	 */
	public static byte[] md5Byte8(byte[] msg) {
		return md5(msg, true);
	}

	/**
	 * 计算文件MD5，返回16字节MD5结果
	 * 
	 * @param file
	 * @return
	 */
	public static byte[] md5Byte16(File file) {
		return md5(file, false);
	}

	/**
	 * 计算文件MD5，返回16字节MD5结果
	 * 
	 * @param file
	 * @return
	 */
	public static byte[] md5Byte8(File file) {
		return md5(file, true);
	}

	/**
	 * 计算MD5 - 文件
	 * 
	 * @param file
	 * @param isByte8
	 * @return
	 */
	private static byte[] md5(File file, boolean isByte8) {
		InputStream in = null;
		try {
			in = new FileInputStream(file);

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] buffer = new byte[8192];
			int len;
			while ((len = in.read(buffer)) != -1) {
				md.update(buffer, 0, len);
			}

			return format(md.digest(), isByte8);
		} catch (Exception e) {
			throw new RuntimeException("Calc stream md5 error", e);

		} finally {
			IOUtil.closeQuietly(in);
		}
	}

	/**
	 * 计算MD5 - 字节数组
	 * 
	 * @param msg
	 * @param isByte8
	 * @return
	 */
	private static byte[] md5(byte[] msg, boolean isByte8) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return format(md.digest(msg), isByte8);
		} catch (Exception e) {
			throw new RuntimeException("Calc md5 error", e);
		}
	}

	/**
	 * 格式化
	 * 
	 * @param md5
	 * @param isByte8
	 * @return
	 */
	private static byte[] format(byte[] md5, boolean isByte8) {
		return (isByte8 ? ByteUtil.subBytes(md5, 4, 12) : md5);
	}

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	private MD5() {
	}
}
