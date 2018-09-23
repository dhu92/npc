package monster;

public enum MonsterType {
    //just random test numbers for now
    Attack("Attack", 1.2, 1.5, 1.1, 1.1, 1.1, 1.0, 1.0, 1.0),
    Tank("Tank", 1.5, 1.1, 1.3, 1.0, 1.0, 1.0, 1.0, 1.1),
    Support("Support", 1.2, 1.1, 1.1, 1.0, 1.0, 1.1, 1.1, 1.0)
    ;

    private final String _name;
    private final double _hpLevelGrowth;
    private final double _attackLevelGrowth;
    private final double _defenseLevelGrowth;
    private final double _critRateLevelGrowth;
    private final double _critDamageLevelGrowth;
    private final double _speedLevelGrowth;
    private final double _accuracyLevelGrowth;
    private final double _resistanceLevelGrowth;

    MonsterType(String name, double hpLevelGrowth, double attackLevelGrowth, double defenseLevelGrowth, double critRateLevelGrowth, double critDamageLevelGrowth, double speedLevelGrowth, double accuracyLevelGrowth, double resistanceLevelGrowth) {
        _name = name;
        _hpLevelGrowth = hpLevelGrowth;
        _attackLevelGrowth = attackLevelGrowth;
        _defenseLevelGrowth = defenseLevelGrowth;
        _critRateLevelGrowth = critRateLevelGrowth;
        _critDamageLevelGrowth = critDamageLevelGrowth;
        _speedLevelGrowth = speedLevelGrowth;
        _accuracyLevelGrowth = accuracyLevelGrowth;
        _resistanceLevelGrowth = resistanceLevelGrowth;
    }

    public String getName(){
        return _name;
    }

    public double getHpLevelGrowth(){
        return _hpLevelGrowth;
    }

    public double getAttackLevelGrowth(){
        return _attackLevelGrowth;
    }

    public double getDefenseLevelGrowth(){
        return _defenseLevelGrowth;
    }

    public double getCritRateLevelGrowth(){
        return _critRateLevelGrowth;
    }

    public double getCritDamageLevelGrowth(){
        return _critDamageLevelGrowth;
    }

    public double getSpeedLevelGrowth(){
        return _speedLevelGrowth;
    }

    public double getAccuracyLevelGrowth(){
        return _accuracyLevelGrowth;
    }

    public double getResistanceLevelGrowth(){
        return _resistanceLevelGrowth;
    }

}
