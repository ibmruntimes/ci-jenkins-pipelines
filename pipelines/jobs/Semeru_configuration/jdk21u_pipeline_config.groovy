class Config21 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac',
                        temurin     : 'xcode15.0.1'
                ],
                additionalTestLabels: [
                        openj9      : ''
                ],
                test                : false,
                configureArgs       : [
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        temurin     : '--enable-dtrace'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile: [
                        openj9      : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker',
                test                : false,
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'hw.arch.x86 && sw.os.linux'
                ],
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)',
                        temurin     : '!(centos6||rhel6)'
                ],
                configureArgs       : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9      : 'EBC:os=windows,arch=x86-64,distro=windows2025',
                        temurin     : 'win2022&&vs2022'
                ],
                cleanWorkspaceAfterBuild: true,
                test                : false,
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        temurin: 'xlc16&&aix720',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.16_1'
                ],
                test                : false,
                additionalTestLabels: [
                        temurin      : 'sw.os.aix.7_2'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : false,
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'ci.project.openj9 && hw.arch.s390x'
                ],
                dockerImage: 'runtimes/ibm-java-8/s390x-redhat7:gcc14_semeru',
                dockerRegistry: 'https://icr.io/',
                dockerCredential : 'ea4b3e98-4334-48d4-8211-98deb8767b55',
                dockerNode : 'sw.tool.docker',
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                test                : false,
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
                ],
                dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                configureArgs       : [
                        'openj9'    : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerNode          : 'sw.tool.docker',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : false,
                configureArgs : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                cleanWorkspaceAfterBuild: true,
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac',
                        temurin     : 'xcode15.0.1'
                ],
                cleanWorkspaceAfterBuild: true,
                test                : false,
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        riscv64Linux      :  [
                os                  : 'linux',
                arch                : 'riscv64',
                crossCompile        : 'qemustatic',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:ubuntu2004_linux-riscv64',
                dockerArgs          : '--platform linux/riscv64',
                test                : false,
                configureArgs       : '--enable-headless-only=yes --enable-dtrace',
                buildArgs           : [
                        ]
        ],

        x64MacIBM    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.mac',
                additionalTestLabels: '',
                test                : 'default',
                configureArgs       : '--enable-dtrace',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        x64LinuxIBM  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile          : 'pipelines/build/dockerFiles/cuda.dockerfile',
                dockerNode          : 'sw.tool.docker',
                test : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.jck.fips140_2",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.jck.OpenJCEPlus",
                        "sanity.openjdk",
                        "sanity.openjdk.fips140_2",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.openjdk.OpenJCEPlus",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.functional.OpenJCEPlus",
                        "extended.jck",
                        "extended.jck.fips140_2",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.jck.OpenJCEPlus",
                        "extended.openjdk",
                        "extended.openjdk.fips140_2",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.openjdk.OpenJCEPlus",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.jck.fips140_2",
                        "special.jck.fips140_3_OpenJCEPlusFIPS",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "special.jck.OpenJCEPlus",
                        "special.openjdk",
                        "special.system",
                        "dev.external",
                        "dev.functional",
                        "dev.openjdk"
                    ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'hw.arch.x86 && sw.os.linux',
                additionalTestLabels: '!(sw.os.cent.6||sw.os.rhel.6)',
                configureArgs       : '--enable-dtrace',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        x64WindowsIBM: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: 'EBC:os=windows,arch=x86-64,distro=windows2025',
                cleanWorkspaceAfterBuild: true,
                test                : 'default',
                configureArgs       : '--with-jdk-rc-name="IBM Semeru Runtime"',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        ppc64AixIBM    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: 'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.16_1',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : '--disable-ccache',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        s390xLinuxIBM    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.jck.fips140_2",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.jck.OpenJCEPlus",
                        "sanity.openjdk",
                        "sanity.openjdk.fips140_2",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.openjdk.OpenJCEPlus",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.functional.OpenJCEPlus",
                        "extended.jck",
                        "extended.jck.fips140_2",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.jck.OpenJCEPlus",
                        "extended.openjdk",
                        "extended.openjdk.fips140_2",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.openjdk.OpenJCEPlus",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.jck.fips140_2",
                        "special.jck.fips140_3_OpenJCEPlusFIPS",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "special.jck.OpenJCEPlus",
                        "special.openjdk",
                        "special.system",
                        "dev.external",
                        "dev.functional",
                        "dev.openjdk"
                    ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'ci.project.openj9 && hw.arch.s390x'
                ],
                dockerImage: 'runtimes/ibm-java-8/s390x-redhat7:gcc14_semeru',
                dockerRegistry: 'https://icr.io/',
                dockerCredential : 'ea4b3e98-4334-48d4-8211-98deb8767b55',
                dockerNode : 'sw.tool.docker',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        ppc64leLinuxIBM    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                test                : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.jck.fips140_2",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.jck.OpenJCEPlus",
                        "sanity.openjdk",
                        "sanity.openjdk.fips140_2",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.openjdk.OpenJCEPlus",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.functional.OpenJCEPlus",
                        "extended.jck",
                        "extended.jck.fips140_2",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.jck.OpenJCEPlus",
                        "extended.openjdk",
                        "extended.openjdk.fips140_2",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.openjdk.OpenJCEPlus",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.jck.fips140_2",
                        "special.jck.fips140_3_OpenJCEPlusFIPS",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "special.jck.OpenJCEPlus",
                        "special.openjdk",
                        "special.system",
                        "dev.external",
                        "dev.functional",
                        "dev.openjdk"
                    ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
                ],
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        aarch64LinuxIBM    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerNode          : 'sw.tool.docker',
                additionalNodeLabels: 'hw.arch.aarch64 && sw.os.linux',
                test                : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.jck.OpenJCEPlus",
                        "sanity.openjdk",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.openjdk.OpenJCEPlus",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.functional.OpenJCEPlus",
                        "extended.jck",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.jck.OpenJCEPlus",
                        "extended.openjdk",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.openjdk.OpenJCEPlus",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.jck.fips140_3_OpenJCEPlusFIPS",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "special.jck.OpenJCEPlus",
                        "special.openjdk",
                        "special.system",
                        "dev.external",
                        "dev.functional",
                        "dev.openjdk"
                    ]
                ],
                configureArgs       : '--enable-dtrace',
                additionalFileNameTag: 'IBM',
                cleanWorkspaceAfterBuild: true,
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        aarch64MacIBM: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac',
                cleanWorkspaceAfterBuild: true,
                test                : 'default',
                configureArgs       : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ]
  ]

}

Config21 config = new Config21()
return config.buildConfigurations
