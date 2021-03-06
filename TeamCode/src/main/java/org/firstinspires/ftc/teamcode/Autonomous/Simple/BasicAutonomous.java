package org.firstinspires.ftc.teamcode.Autonomous.Simple;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.DriveTime;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Wait;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.Robot;

/**
 * Created by ethan.hampton on 11/3/2017.
 * <p>
 * A simple autonomous that simply moves forward
 */
@Disabled
@Autonomous(name = "Basic Autonomous")
public class BasicAutonomous extends OpMode {
    private AutonomousBase auto = new AutonomousBase();
    private Robot bot;
    private final Module[][] steps = new Module[][]{
            {new DriveTime().setSpeeds(0.85, 0, 0).setTime(2000)},
            // {new CallFunction().setFunction(() -> bot.driveMecanum.driveMecanum(0.9, 0, 0))},
            {new Wait().setWaitTime(2000)},
            //{new CallFunction().setFunction(() -> bot.driveMecanum.driveMecanum(-0.9, 0, 0))},
            {new Wait().setWaitTime(2000)},
            //{new CallFunction().setFunction(() -> bot.driveMecanum.driveMecanum(0, 0, 0))},
            {new Wait()}
    };

    @Override
    public void init() {
        bot = new Robot();
        auto.init(hardwareMap, bot, steps);
    }

    @Override
    public void loop() {
        auto.loop();

        telemetry.addData("Test", bot.drive.isFunctioning());//Add telemetry
    }
}