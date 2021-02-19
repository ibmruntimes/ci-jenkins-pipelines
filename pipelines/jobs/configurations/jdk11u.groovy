targetConfigurations = [
        "x64Mac"        : [ "openj9" ],
        "x64Linux"      : [ "openj9" ],
        "x64Windows"    : [ "openj9" ],
        "ppc64Aix"      : [ "openj9" ],
        "ppc64leLinux"  : [ "openj9" ],
        "s390xLinux"    : [ "openj9" ],
        "aarch64Linux"  : [ "openj9" ],
        "riscv64Linux"  : [ "openj9" ]
]

// 18:05 Tue, Thur
triggerSchedule_nightly="TZ=UTC\n05 18 * * 2,4"
// 17:05 Sat
triggerSchedule_weekly="TZ=UTC\n05 17 * * 6"

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
        "openj9"         : ""
]

return this
