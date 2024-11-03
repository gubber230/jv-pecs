package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import core.mate.academy.service.impl.BulldozerProducer;
import core.mate.academy.service.impl.ExcavatorProducer;
import core.mate.academy.service.impl.TruckProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    @Override

    public List<Machine> getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            return new ArrayList<>(new BulldozerProducer().get());
        } else if (type == Excavator.class) {
            return new ArrayList<>(new ExcavatorProducer().get());
        } else if (type == Truck.class) {
            return new ArrayList<>(new TruckProducer().get());
        }
        return List.of();
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        int size = machines.size();

        if (size < 25) {
            for (int i = 0; i < size; i++) {
                machines.set(i, value);
            }
        } else {
            ListIterator<? super Machine> itr = machines.listIterator();
            for (int i = 0; i < size; i++) {
                itr.next();
                itr.set(value);
            }
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {

    }
}
