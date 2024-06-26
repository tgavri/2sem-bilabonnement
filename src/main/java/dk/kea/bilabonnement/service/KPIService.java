package dk.kea.bilabonnement.service;

import dk.kea.bilabonnement.model.BilModel;
import dk.kea.bilabonnement.model.Lejeaftale;
import dk.kea.bilabonnement.repository.BilRepo;
import dk.kea.bilabonnement.repository.LejeaftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KPIService {
    //lavet af Jannick
    KPIService() {
    }

    @Autowired
    BilRepo bilRepo;

    @Autowired
    LejeaftaleRepo lejeaftaleRepo;

    public List<BilModel> kpiManageCriteria(String status, String brand, String carModel, String type, String fuel) {
        return bilRepo.searchByKPI(status, brand, carModel, type, fuel);
    }

    public int gnslejeperiodehent(List<BilModel> bilList) {
        int sum = 0;
        int count = 0;

        for (BilModel l : bilList) {
            List<Integer> templist = lejeaftaleRepo.findUdlejningsPeriodeByChassisNumber(l.getChassisNumber());
            if (!templist.isEmpty()) {
                for (int m : templist) {
                    sum += m;
                    count++;
                }
            }
        }
        // vi undgår at dividere med 0
        if (count == 0) {
            return 0;
        } else {
            // returner gennemsnittet
            return sum / count;
        }
    }

    public int gnsskadeprishent(List<BilModel> bilList) {
        int sum = 0;
        int count = 0;

        if (!bilList.isEmpty()) {
            for (BilModel l : bilList) {
                List<Integer> templist = lejeaftaleRepo.findSkadePrisByChassisNumber(l.getChassisNumber());
                if (!templist.isEmpty()) {
                    for (int m : templist) {
                        sum += m;
                        count++;
                    }
                }
            }
        }
        // vi undgår at dividere med 0
        if (count == 0) {
            return 0;
        } else {
            // returner gennemsnittet
            return sum / count;
        }
    }

    public double gnsudlejepris(List<BilModel> bilList) {
        double totalSum = 0;
        int totalCount = 0;

        if (!bilList.isEmpty()) {
            for (BilModel l : bilList) {
                List<Lejeaftale> templist = lejeaftaleRepo.findLejePrisByChassisNumber(l.getChassisNumber());
                if (!templist.isEmpty()) {
                    for (Lejeaftale m : templist) {
                        int k = switch (m.getUdlejnings_Type()) {
                            case "Limited" -> 2500;
                            case "Unlimited" -> 3000;
                            default -> 0;
                        };
                        k = k * m.getUdlejningsperiode();
                        totalSum += k;
                        totalCount++;
                    }
                }
            }
        }

        if (totalCount > 0) {
            return totalSum / totalCount;
        } else {
            return 0;
        }
    }

    public List<Integer> totalpris() {
        ArrayList<Integer> returnlist = new ArrayList<>();
        int totalSum = 0;
        int totalCount = 0;
        List<Lejeaftale> templist = lejeaftaleRepo.findRentedCars();
        if (!templist.isEmpty()) {
            for (Lejeaftale m : templist) {
                int k = switch (m.getUdlejnings_Type()) {
                    case "Limited" -> 2500;
                    case "Unlimited" -> 3000;
                    default -> 0;
                };
                k = k * m.getUdlejningsperiode();
                totalSum += k;
                totalCount++;
            }
        }

        returnlist.add(totalCount);
        returnlist.add(totalSum);


        return returnlist;
    }
}

