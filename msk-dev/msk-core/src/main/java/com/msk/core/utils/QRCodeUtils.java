package com.msk.core.utils;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * QRCodeUtils
 *
 * @author jiang_nan
 * @version 1.0
 **/
public final class QRCodeUtils {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(QRCodeUtils.class);
    private static final String CODE = "utf-8";
    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;

    /**
     * 生成RQ二维码
     *
     * @author wuhongbo
     * @param str
     *        内容
     * @param height
     *        高度（px）
     *
     */
    public static BufferedImage getQR(String str, Integer height) {
        logger.debug("create QR Code");
        if (height == null || height < 100) {
            height = 200;
        }

        try {
            // 文字编码
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, CODE);

            BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, height, height, hints);

            return toBufferedImage(bitMatrix);

            // 输出方式
            // 网页
            // ImageIO.write(image, "png", response.getOutputStream());

            // 文件
            // ImageIO.write(image, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成一维码（128）
     *
     * @author wuhongbo
     * @param str
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage getBarcode(String str, Integer width, Integer height) {

        if (width == null || width < 200) {
            width = 200;
        }

        if (height == null || height < 50) {
            height = 50;
        }

        try {
            // 文字编码
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, CODE);

            BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.CODE_128, width, height, hints);

            return toBufferedImage(bitMatrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成二维码，写到文件中
     *
     * @author wuhongbo
     * @param str
     * @param height
     * @param file
     * @throws IOException
     */
    public static void getRQWriteFile(String str, Integer height, File file) throws IOException {
        BufferedImage image = getQR (str, height);
        ImageIO.write(image, "png", file);
    }

    /**
     * 生成一维码，写到文件中
     *
     * @author wuhongbo
     * @param str
     * @param height
     * @param file
     * @throws IOException
     */
    public static void getBarcodeWriteFile(String str, Integer width, Integer height, File file) throws IOException {
        BufferedImage image = getBarcode(str, width, height);
        ImageIO.write(image, "png", file);
    }

    /**
     * 转换成图片
     *
     * @author wuhongbo
     * @param matrix
     * @return
     */
    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    // /**
    // * 解码(二维、一维均可)
    // */
    // public static String read(File file)
    // {
    //
    // BufferedImage image;
    // try
    // {
    // if (file == null || file.exists() == false)
    // {
    // throw new Exception(" File not found:" + file.getPath());
    // }
    //
    // image = ImageIO.read(file);
    //
    // LuminanceSource source = new BufferedImageLuminanceSource(image);
    // BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
    //
    // Result result;
    //
    // // 解码设置编码方式为：utf-8，
    // Hashtable hints = new Hashtable();
    // hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
    //
    // result = new MultiFormatReader().decode(bitmap, hints);
    //
    // return result.getText();
    //
    // }
    // catch (Exception e)
    // {
    // e.printStackTrace();
    // }
    //
    // return null;
    // }
}
