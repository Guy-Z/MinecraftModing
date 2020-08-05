package com.example.examplemod.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.fonts.Font;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.OptionSlider;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ObsidianGui extends Screen {

    private TextFieldWidget textFieldWidget;
    private Button button;
    private OptionSlider optionSlider;
    private ResourceLocation OBSIDIAN_GUI_TEXTURE = new ResourceLocation("examplemod", "textures/gui/obsidian_gui_texture.jpg");
    private String content = "Obsidian Gui";
    private SliderPercentageOption sliderPercentageOption;
    private Widget sliderBar;


    public ObsidianGui(ITextComponent titleIn) {
        super(titleIn);
    }

    @Override
    protected void init() {
        minecraft.keyboardListener.enableRepeatEvents(true);
        textFieldWidget = new TextFieldWidget(font,width / 2 - 100, 66, 200, 20, "Context");
        //添加写入事件
        children.add(textFieldWidget);

        button = new Button(width / 2 - 40, 96, 80, 20, "Save", (button) -> {});
        addButton(button);
//
//        sliderPercentageOption = new SliderPercentageOption(
//                "examplemod.sliderbar",
//                5,
//                100,
//                5,
//                (setting) -> (double) 0,
//                (setting, value) -> {},
//                (gameSettings, sliderPercentageOption1) -> "test");
//        sliderBar = sliderPercentageOption.createWidget(Minecraft.getInstance().gameSettings, width / 2 - 100, 120, 200);
//        children.add(sliderBar);

        super.init();
    }

    @Override
    public void render(int mouseX, int mouseY, float particleTick) {
        this.renderBackground();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.getTextureManager().bindTexture(OBSIDIAN_GUI_TEXTURE);
        int textureWidth = 300;
        int textureHeight = 200;
        blit(width / 2 - 150, 10, 0, 0, 300, 200, textureWidth, textureHeight);

        drawString(font, content, width / 2 -30, 30, 0xeeeeee);
//        textFieldWidget.render(mouseX, mouseY, particleTick);
        button.render(mouseX, mouseY, particleTick);
//        sliderBar.render(mouseX, mouseY, particleTick);

        super.render(mouseX, mouseY, particleTick);
    }
}
