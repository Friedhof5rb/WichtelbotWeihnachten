package me.Friedhof5rb.commands;

import java.util.Collections;
import me.Friedhof5rb.Main;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class wichtelnCommand extends ListenerAdapter {
    public wichtelnCommand() {
    }

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("wichtel")) {
            Main.wichtelTeilnehmer.clear();
            if (event.getInteraction().getOption("nachricht") == null) {
                event.reply("Du musste eine Nachricht anhängen.").queue();
                return;
            }

            Main.nachricht = event.getInteraction().getOption("nachricht").getAsString();

            int i;
            for(i = 0; i < 20; ++i) {
                int n = i + 1;
                OptionMapping optionMapping = event.getInteraction().getOption("user" + n);
                if (optionMapping != null) {
                    User user = optionMapping.getAsUser();
                    Main.wichtelTeilnehmer.add(user);
                }
            }

            Collections.shuffle(Main.wichtelTeilnehmer);

            for(i = 0; i < Main.wichtelTeilnehmer.size(); ++i) {
                String teilnehmer;
                if (i == Main.wichtelTeilnehmer.size() - 1) {
                    teilnehmer = ((User)Main.wichtelTeilnehmer.get(0)).getName();
                } else {
                    teilnehmer = ((User)Main.wichtelTeilnehmer.get(i + 1)).getName();
                }

                ((User)Main.wichtelTeilnehmer.get(i)).openPrivateChannel().flatMap((channel) -> {
                    return channel.sendMessage("Es wird gewichtelt! Du beschenkst: " + teilnehmer + " und der Organisator moechte dir folgendes mitteilen: " + Main.nachricht);
                }).queue();
            }

            event.reply("Wichtel erfolgreich informiert!").queue();
        }

    }
}