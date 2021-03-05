targetConfigurations = [
        "x64Mac"        : [ "openj9" ],
        "x64Linux"      : [ "openj9" ],
        "x64Windows"    : [ "openj9" ],
        "ppc64Aix"      : [ "openj9" ],
        "ppc64leLinux"  : [ "openj9" ],
        "s390xLinux"    : [ "openj9" ],
        "aarch64Linux"  : [ "openj9" ],
        "riscv64Linux"  : [ "openj9" ],
        "x64MacIBM"        : [ "openj9" ],
        "x64LinuxIBM"      : [ "openj9" ],
        "x64WindowsIBM"    : [ "openj9" ],
        "ppc64AixIBM"      : [ "openj9" ],
        "ppc64leLinuxIBM"  : [ "openj9" ],
        "s390xLinuxIBM"    : [ "openj9" ]
]

// Weeknights at H9:00pm
triggerSchedule_nightly="H 21 * * 1-4"
// H9:00am Sat
triggerSchedule_weekly="H 21 * * 5"

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
        "openj9"         : ""
]

return this
