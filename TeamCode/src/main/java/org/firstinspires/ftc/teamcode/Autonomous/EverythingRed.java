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
 * Created by byron.nice on 2/9/2018.
 *
 * does everything for red
 */

@Autonomous(name = "RED: Everything", group = "Red")
public class EverythingRed extends OpMode {
    private AutonomousBase auto = new AutonomousBase();
    private Robot robot;

    private Module[][] modules = {
            {new JewelHitter().setTeam(Team.RED_TEAM)},
            {new Cryptograms()}, //Decrypts Cryptogram
            {new CallFunction().setFunction(()-> robot.forklift.close())}, //Close claws
            {new Wait().setWaitTime(300)},//Wait
            {new CallFunction().setFunction(()-> robot.forklift.raise(0.4))}, //Raise Forklift
            {new Wait().setWaitTime(500)},//Wait
            {new CallFunction().setFunction(()-> robot.forklift.raise(0.0))},//Stop Forklift
            {new Wait().setWaitTime(300)},//Wait
            {new DriveTime().setSpeeds(-0.4,0,0).setTime(2500)},
            {new DriveTime().setSpeeds(0,0.5,0).setTime(2800)},
            {new Wait().setWaitTime(500)},//Waits
            {
                    new DriveTime().setSpeeds(0,0,-0.6).setTime(1400),
                    new DriveTime().setSpeeds(0,0,-0.6).setTime(950),
                    new DriveTime().setSpeeds(0,0,-0.6).setTime(550),
            },//the three possible positions for the cryptobox
            {new EncoderDrive().setDistances(5,5).setSpeed(0.3)},//Move Forward
            {new CallFunction().setFunction(() -> robot.forklift.open())}, //Open claws
            {new Wait().setWaitTime(300)},//wait to open before continuing back
            {new DriveTime().setSpeeds(-0.2,0,0).setTime(600)},//Moves back
            {new Wait()}
    };

    @Override
    public void init() {
        robot = new Robot();
        auto.setTelemetry(telemetry);
        auto.init(hardwareMap, robot, modules);
    }

    @Override
    public void loop() {
        telemetry.addData("Time", robot.getTimeMilliseconds());
    }
}
