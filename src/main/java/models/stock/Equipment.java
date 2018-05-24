package models.stock;

public class Equipment extends Stock{

    private EquipmentType equipmentType;

    public Equipment() {
    }

    public Equipment(double price, int quanity, EquipmentType equipmentType) {
        super(price, quanity);
        this.equipmentType = equipmentType;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
}
