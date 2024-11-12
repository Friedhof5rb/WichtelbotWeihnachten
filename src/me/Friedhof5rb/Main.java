
package me.Friedhof5rb;

import java.util.ArrayList;
import me.Friedhof5rb.commands.wichtelnCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Main {
    public static ArrayList<User> wichtelTeilnehmer = new ArrayList();
    public static String nachricht = "";

    public Main() {
    }

    public static void main(String[] args) {
        String token = args[0];
        JDABuilder builder = JDABuilder.createDefault(token).setChunkingFilter(ChunkingFilter.ALL).setMemberCachePolicy(MemberCachePolicy.ALL).enableIntents(GatewayIntent.GUILD_MEMBERS, new GatewayIntent[0]);
        builder.setActivity(Activity.customStatus("Stalking Santa Clause"));
        builder.addEventListeners(new Object[]{new wichtelnCommand()});
        JDA jda = builder.build();
        CommandListUpdateAction commands = jda.updateCommands();
        commands.addCommands(new CommandData[]{Commands.slash("wichtel", "Legt die Partner fÃ¼rs wichteln fest.").addOption(OptionType.STRING, "nachricht", "Eine Nachricht die mitgesendet wird.").addOption(OptionType.USER, "user1", "User").addOption(OptionType.USER, "user2", "User").addOption(OptionType.USER, "user3", "User").addOption(OptionType.USER, "user4", "User").addOption(OptionType.USER, "user5", "User").addOption(OptionType.USER, "user6", "User").addOption(OptionType.USER, "user7", "User").addOption(OptionType.USER, "user8", "User").addOption(OptionType.USER, "user9", "User").addOption(OptionType.USER, "user10", "User").addOption(OptionType.USER, "user11", "User").addOption(OptionType.USER, "user12", "User").addOption(OptionType.USER, "user13", "User").addOption(OptionType.USER, "user14", "User").addOption(OptionType.USER, "user15", "User").addOption(OptionType.USER, "user16", "User").addOption(OptionType.USER, "user17", "User").addOption(OptionType.USER, "user18", "User").addOption(OptionType.USER, "user19", "User").addOption(OptionType.USER, "user20", "User")}).queue();
        System.out.println("Hello world!");
    }
}
