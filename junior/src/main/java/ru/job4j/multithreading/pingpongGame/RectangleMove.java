package ru.job4j.multithreading.pingpongGame;

import javafx.scene.shape.Rectangle;

/**
 * Класс передвижения.
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;

    RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        double moveX = 1;
        double moveY = 0.5;
        while (!Thread.interrupted()){
            if (this.rect.getX() >= 300 || this.rect.getX() <= 0){
                moveX *= -1;
            }

            if (this.rect.getY() >= 300 || this.rect.getY() <= 0){
                moveY *= -1;
            }

            this.rect.setX(this.rect.getX() + moveX);
            this.rect.setY(this.rect.getY() + moveY);

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
