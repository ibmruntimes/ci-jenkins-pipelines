targetConfigurations = [
        "x64MacIBM"        : [ "openj9" ],
        "x64LinuxIBM"      : [ "openj9" ],
        "x64WindowsIBM"    : [ "openj9" ],
        "ppc64AixIBM"      : [ "openj9" ],
        "ppc64leLinuxIBM"  : [ "openj9" ],
        "s390xLinuxIBM"    : [ "openj9" ]
]

// Weeknights at H9:00pm
triggerSchedule_nightly="0 21 * * 1-4"
// H9:00am Sat
triggerSchedule_weekly="0 21 * * 5"

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
        "openj9"         : "ibm_11.0.12.0_release"
]

return this
