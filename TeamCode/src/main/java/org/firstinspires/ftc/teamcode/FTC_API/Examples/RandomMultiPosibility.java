package org.firstinspires.ftc.teamcode.FTC_API.Examples;

import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.FTC_API.Options;

import java.util.Random;

/**
 * Created by Ethan Hampton on 8/19/17.
 *
 * Simple drive for time module
 */

class RandomMultiPosibility extends Module {
    private Options options = new Options("Random");

    @Override
    public void start(){

    }

    @Override
    public void tick(){
    }

    @Override
    public int stop(){
        //picks one of two next steps
        return new Random().nextInt(1);
    }

    @Override
    public Options options() {
        return options;
    }

    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public String[] requiredSubSystems() {
        return null;
    }


}
