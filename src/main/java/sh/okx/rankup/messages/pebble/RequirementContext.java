package sh.okx.rankup.messages.pebble;

import org.bukkit.entity.Player;
import sh.okx.rankup.requirements.Requirement;

public class RequirementContext {

  private final Player player;
  private final Requirement requirement;

  public RequirementContext(Player player, Requirement requirement) {
    this.player = player;
    this.requirement = requirement;
  }

  public double getTotal() {
    return requirement.getTotal(player);
  }

  public boolean getDone() {
    return requirement.check(player);
  }

  public double getRemaining() {
    return requirement.getRemaining(player);
  }

  public double getProgress() {
    return requirement.getTotal(player) - requirement.getRemaining(player);
  }

  public String getName() {
    return requirement.getName();
  }

  public String getSub(){
    return requirement.getSub();
  }

  public double getQuotient() {
    return (getTotal() > 0 ? (getProgress() / getTotal()) : 1);
  }

  public double getPercent() {
    return getQuotient() * 100;
  }

  public String toString() {
    return "Requirements[" + requirement.getFullName() + "]";
  }
}
