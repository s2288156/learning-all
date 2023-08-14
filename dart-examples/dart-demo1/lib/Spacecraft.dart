class Spacecraft {
  String name;
  DateTime? launchData;

  int? get launchYear => launchData?.year;

  Spacecraft(this.name, this.launchData);

  Spacecraft.unlaunched(String name) : this(name, null);

  void describe() {
    print('Spacecraft: $name');
    var launchData = this.launchData;
    if(launchData != null) {
      int year = DateTime.now().difference(launchData).inDays ~/ 365;
      print('Launched: $launchYear ($year years ago)');
    } else {
      print('Unlaunched');
    }
  }

}
