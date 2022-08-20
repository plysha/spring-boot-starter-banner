package ru.plysha.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.env.Environment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.PrintStream;

public class CustomBanner implements Banner {
    private static final String SPRING_BANNER_NAME = "spring.banner.name";
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 80;
    private static final int COLOR_VALUE = -16777216;
    private static final String SPRING_BOOT_FOOTER_TEMPLATE = ":: Spring Boot :: (v%s)\n";

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
        int width = DEFAULT_WIDTH;
        int height = DEFAULT_HEIGHT;
        String bannerLogo = environment.getProperty(SPRING_BANNER_NAME);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 24));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(bannerLogo, 10, 20);

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();

            for (int x = 0; x < width; x++) {
                sb.append(image.getRGB(x, y) == COLOR_VALUE ? " " : "$");
            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            printStream.println(sb);
        }

        printStream.printf(SPRING_BOOT_FOOTER_TEMPLATE, SpringBootVersion.getVersion());
    }
}