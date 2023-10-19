package com.secondTutorial;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Mandelbrot {
    public static int mandelbrot(Complex c, int maxIterations) {
        Complex z = new Complex(0, 0);
        int iterations = 0;
        while (iterations < maxIterations && z.abs() < 2) {
            z = z.multiply(z).add(c);
            iterations++;
        }
        return iterations;
    }

    public static void main(String[] args) {
        int width = 1920;
        int height = 1080;
        int maxIterations = 1000;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double real = (x - width / 2) * 4.0 / width;
                double imag = (y - height / 2) * 4.0 / width;
                Complex c = new Complex(real, imag);
                int iterations = mandelbrot(c, maxIterations);
                Color color = new Color(iterations % 256, iterations % 256, iterations % 256);
                image.setRGB(x, y, color.getRGB());
            }
        }
        try {
            ImageIO.write(image, "png", new File("mandelbrot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


