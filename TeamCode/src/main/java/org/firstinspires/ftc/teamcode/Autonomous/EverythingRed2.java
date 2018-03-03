
package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.*;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.CallFunction;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Utilitys.Team;

/**
 * Created by Ethan Hampton
 * Does every autonomous challenge for the red 2 stone.
 */

@Autonomous(name = "RED2: Everything", group = "Red")
public class EverythingRed2 extends OpMode {
    private AutonomousBase auto = new AutonomousBase();
    private Robot bot;
    private final Module[][] steps = new Module[][]{
            {new JewelHitter().setTeam(Team.RED_TEAM)},
            {new Cryptograms()}, //Decrypts Cryptogram
            {new CallFunction().setFunction(() -> bot.forklift.closeAll())}, //Close claws
            {new Wait().setWaitTime(300)},//Wait
            {new CallFunction().setFunction(() -> bot.forklift.raise(0.4))}, //Raise Forklift
            {new Wait().setWaitTime(700)},//Wait
            {new CallFunction().setFunction(() -> bot.forklift.raise(0.0))},//Stop Forklift
            {new Wait().setWaitTime(500)},//Waits
            {new EncoderDrive().setDistances(-27, -27).setSpeed(0.4)},
            {new Wait().setWaitTime(300)},//Wait
            {new EncoderDrive().setDistances(19, -19).setSpeed(0.4)},
            {new Wait().setWaitTime(300)},//Wait
            {
                    new EncoderDrive().setDistances(16.5, 16.5).setSpeed(0.4),//LEFT
                    new EncoderDrive().setDistances(9.5, 9.5).setSpeed(0.4),//Center
                    new EncoderDrive().setDistances(2.5, 2.5).setSpeed(0.4),//Right
            },//the three possible positions for the cryptobox
            {new EncoderDrive().setDistances(19, -19).setSpeed(0.4)},
            {new Wait().setWaitTime(300)},
            {new EncoderDrive().setDistances(10, 10).setSpeed(0.4)},//Move Forward
            {new CallFunction().setFunction(() -> bot.forklift.openAll())}, //Open claws
            {new Wait().setWaitTime(300)},//wait to openAll before continuing back
            {new EncoderDrive().setDistances(-5, -5).setSpeed(0.4)},
            {new Wait()},
    };

    @Override
    public void init() {
        bot = new Robot();
        auto.setTelemetry(telemetry);
        auto.init(hardwareMap, bot, steps);
    }

    @Override
    public void loop() {
        auto.loop();

        telemetry.addData("Test", bot.drive.isFunctioning());//Add telemetry
    }
}
