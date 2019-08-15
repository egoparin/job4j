package ru.job4j.multithreading.pingpongGame;

import javafx.scene.shape.Rectangle;

/**
 * Класс передвижения.
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private double moveX = 1;
    private double moveY = 0.5;

    RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            if (this.rect.getX() >= 300 || this.rect.getX() <= 0){
                this.moveX *= -1;
            }

            if (this.rect.getY() >= 300 || this.rect.getY() <= 0){
                this.moveY *= -1;
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
