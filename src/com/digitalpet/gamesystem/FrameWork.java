package com.digitalpet.gamesystem;

import com.digitalpet.object.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class FrameWork extends JFrame {
    private Pet pet;
    private final Master master = new Master();
    GameSystem gameSystem =new GameSystem();
    private final JPanel panel = new JPanel();
    private final JPanel gamePanel = new JPanel();
    private final JPanel choosePetPanel = new JPanel();

    //ActionListeners :
    private final ActionListener catSwitcher = e -> {
        pet = new Cat();
        switchToGameFrame();
    };
    private final ActionListener dogSwitcher = e -> {
        pet= new Dog();
        switchToGameFrame();
    };
    private final ActionListener penguinSwitcher = e -> {
        pet = new Penguin();
        switchToGameFrame();
    };
     private final ActionListener switcher2 = e -> {
        switchToChoiceFrame();
    };
     private final ActionListener backAction = e -> {
       switchToTopFrame();
     };
     private final ActionListener feedAction = e ->{
         feedIt();
     };
     private final ActionListener touchAction = e->{
         touchIt();
     };
     private final ActionListener statusAction = e -> {
         showStatus();
     };

    private void showStatus() {
        pet.showStatus();
    }

    private void touchIt() {
        master.touch(pet);
    }

    private void feedIt() {
        master.feed(pet);
    }

    private void switchToTopFrame() {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), "Panel 1");
        initial();
    }

    private void switchToChoiceFrame(){
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), "Panel 2");
        choosePetFrame();
    }
    private void switchToGameFrame(){
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), "Panel 3");
        gameFrame();
    }
    private void choosePetFrame() {
        Color color= new Color(255,255,190);
        choosePetPanel.setLayout(null);
        choosePetPanel.setBackground(color);
        JButton catBtn = new JButton("猫");
        JButton dogBtn = new JButton("狗");
        JButton penguinBtn = new JButton("企鹅");
        JLabel label = new JLabel("选择你的宠物");
        Font font = new Font("宋体",Font.BOLD,70);
        choosePetPanel.add(label);
        choosePetPanel.add(catBtn);
        choosePetPanel.add(dogBtn);
        choosePetPanel.add(penguinBtn);
        label.setFont(font);
        label.setBounds(185,10,600,200);
        catBtn.setBounds(150,400,100,50);
        catBtn.addActionListener(catSwitcher);
        dogBtn.setBounds(350,400,100,50);
        dogBtn.addActionListener(dogSwitcher);
        penguinBtn.setBounds(550,400,100,50);
        penguinBtn.addActionListener(penguinSwitcher);
    }

    private void gameFrame() {
        gamePanel.setLayout(null);
        JButton feedBtn = new JButton("feed");
        JButton touchBtn = new JButton("touch");
        JButton backBtn = new JButton("←");
        JButton statusBtn = new JButton("status");
        WindowPanel window = new WindowPanel();
        DogPanel dogPanel = new DogPanel();
        gamePanel.add(feedBtn);
        gamePanel.add(touchBtn);
        gamePanel.add(window);
        gamePanel.add(dogPanel);
        gamePanel.add(backBtn);
        dogPanel.setBounds(50,50,200,200);
        window.setLayout(null);
        window.setBackground(Color.black);
        window.add(dogPanel);
        window.setBounds(0,0,600,400);
        feedBtn.setBounds(600,0,200,50);
        touchBtn.setBounds(600,50,200,50);
        backBtn.setBounds(0,480,50,30);
        feedBtn.addActionListener(feedAction);
        touchBtn.addActionListener(touchAction);
        backBtn.addActionListener(backAction);
    }

    public void initial() {
        JButton startBtn = new JButton("Start");
        JLabel titleLabel = new JLabel("电子宠物");
        Font font = new Font("宋体",Font.BOLD,70);
        Color color= new Color(255,255,190);
        this.setSize(800,550);
        this.setTitle("DigitalPet");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        panel.setBackground(color);
        panel.setLayout(null);
        panel.add(startBtn);
        panel.add(titleLabel);
        titleLabel.setFont(font);
        titleLabel.setBackground(Color.black);
        titleLabel.setBounds(250,150,300,100);
        startBtn.setBounds(300,350,200,50);
        startBtn.setBorderPainted(false);
        startBtn.addActionListener(switcher2);
        this.add(panel);
        this.setVisible(true);
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(panel, "Panel 1");
        getContentPane().add(choosePetPanel, "Panel 2");
        getContentPane().add(gamePanel, "Panel 3");
    }

}
