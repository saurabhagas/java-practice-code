package com.saurabh.conceptual.restaurant_design.staff;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static com.saurabh.source.common.ObjectUtils.requireNonEmpty;

public class Staff {
  private final Manager manager;
  private final Receptionist receptionist;
  private final List<Waiter> waiters;
  private final List<Chef> chefs;

  public Staff(Manager manager, Receptionist receptionist, List<Waiter> waiters, List<Chef> chefs) {
    this.manager = requireNonNull(manager);
    this.receptionist = requireNonNull(receptionist);
    this.waiters = requireNonEmpty(waiters);
    this.chefs = requireNonEmpty(chefs);
  }

  public Manager getManager() {
    return manager;
  }

  public Receptionist getReceptionist() {
    return receptionist;
  }

  public boolean addWaiter(Waiter waiter) {
    return waiters.add(waiter);
  }

  public boolean removeWaiter(Waiter waiter) {
    return waiters.remove(waiter);
  }

  public List<Waiter> getWaiters() {
    return waiters;
  }

  public boolean addChef(Chef chef) {
    return chefs.add(chef);
  }

  public boolean removeChef(Chef chef) {
    return chefs.remove(chef);
  }

  public List<Chef> getChefs() {
    return chefs;
  }
}
